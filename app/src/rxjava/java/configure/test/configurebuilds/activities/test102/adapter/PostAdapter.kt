package configure.test.configurebuilds.activities.test102.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import configure.test.configurebuilds.R
import configure.test.configurebuilds.activities.test102.models.Post

/**
 * Created by Pankaj Nimgade on 5/20/2020.
 */
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