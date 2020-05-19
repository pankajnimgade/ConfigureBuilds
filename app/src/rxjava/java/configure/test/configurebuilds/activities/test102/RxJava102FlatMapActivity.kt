package configure.test.configurebuilds.activities.test102

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import configure.test.configurebuilds.R
import configure.test.configurebuilds.activities.test102.models.Post
import configure.test.configurebuilds.activities.test102.requests.ServiceGenerator
import configure.test.configurebuilds.databinding.ActivityRxJava102FlatMapBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*


class RxJava102FlatMapActivity : AppCompatActivity() {

    private val TAG = "RxJava102FlatMap"

    private lateinit var binding: ActivityRxJava102FlatMapBinding

    private var adapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rx_java102_flat_map)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initializeUi()
    }

    private fun initializeUi() {
        binding.recyclerView.adapter = adapter

        getPostsObservable()
                .subscribeOn(Schedulers.io())
                .flatMap {
                    return@flatMap getCommentsObservable(it)
                }
                .observeOn(Schedulers.io())
                .subscribe({
                    Log.d(TAG, ": OnNext was Called")
                    Log.d(TAG, ": ${it.title}")
                    adapter.updatePosts(it)
                }, {
                    Log.e(TAG, ": onError was called")
                }, {
                    Log.d(TAG, ": OnComplete was called")
                })
    }

    private fun getCommentsObservable(post: Post): Observable<Post> {
        return ServiceGenerator.getRequestApi()
                .getComments(post.id)
                .map {
                    val delay = Random().nextInt(5) * 500
                    Thread.sleep(delay.toLong())
                    post.comments = it
                    return@map post
                }.subscribeOn(Schedulers.io())
    }

    private fun getPostsObservable(): Observable<Post> {
        return ServiceGenerator.getRequestApi()
                .getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap {
                    adapter.setPosts(it)
                    Observable.fromIterable(it).subscribeOn(Schedulers.io())
                }
    }

    class PostAdapter(var list: MutableList<Post> = mutableListOf()) :
            RecyclerView.Adapter<PostAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            private val postTextView = itemView.findViewById<TextView>(R.id.post_text_view)
            private val commentTextView = itemView.findViewById<TextView>(R.id.comments_text_view)
            private val progressBar = itemView.findViewById<ProgressBar>(R.id.progressBar)

            fun onBind(post: Post) {
                postTextView.text = post.title

                if (post.comments.isNullOrEmpty()) {
                    progressBar.visibility = View.VISIBLE
                    commentTextView.text = ""
                } else {
                    commentTextView.text = post.comments.size.toString() ?: "0"
                    progressBar.visibility = View.GONE
                }
            }
        }

        fun setPosts(posts: List<Post>) {
            this.list = posts.toMutableList()
            notifyDataSetChanged()
        }

        fun updatePosts(post: Post) {
            list[list.indexOf(post)] = post
            notifyItemChanged(list.indexOf(post))
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.layout_post_list_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val post = list[position]
            holder.onBind(post)
        }
    }
}
