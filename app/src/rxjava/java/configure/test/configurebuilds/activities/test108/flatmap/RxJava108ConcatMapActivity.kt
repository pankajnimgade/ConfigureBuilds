package configure.test.configurebuilds.activities.test108.flatmap

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import configure.test.configurebuilds.R
import configure.test.configurebuilds.activities.test102.adapter.PostAdapter
import configure.test.configurebuilds.activities.test102.models.Post
import configure.test.configurebuilds.activities.test102.requests.ServiceGenerator
import configure.test.configurebuilds.databinding.ActivityRxJava108ConcatMapBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class RxJava108ConcatMapActivity : AppCompatActivity() {

    private val TAG = "RxJava108ConcatMap"

    private lateinit var binding: ActivityRxJava108ConcatMapBinding

    private val compositeDisposable = CompositeDisposable()

    private val adapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rx_java108_concat_map)

        binding.recyclerView.adapter = adapter
        initializeUi()
    }

    private fun initializeUi() {
        val disposable = getPostsObservable()
                .subscribeOn(Schedulers.io())
                .concatMap {
                    return@concatMap getCommentObservable(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, ": OnNext was Called")
                    Log.d(TAG, ": ${it.title}")
                    adapter.updatePosts(it)
                }, {
                    Log.d(TAG, ": onComplete was called")
                }, {
                    Log.d(TAG, ": onError called")
                })


        compositeDisposable.add(disposable)
    }

    private fun getCommentObservable(post: Post): Observable<Post> {
        return ServiceGenerator
                .getRequestApi()
                .getComments(post.id)
                .map {
                    val delay = ((Random().nextInt(2)) * 500)
                    Thread.sleep(delay.toLong())
                    Log.d(TAG, "${Thread.currentThread().name} sleeps for $delay")
                    post.comments = it.toMutableList()
                    return@map post
                }.subscribeOn(Schedulers.io())
    }

//    private fun

    private fun getPostsObservable(): Observable<Post> {
        return ServiceGenerator
                .getRequestApi()
                .getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .concatMap {
                    adapter.setPosts(it)
                    return@concatMap Observable.fromIterable(it).subscribeOn(Schedulers.io())
                }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
