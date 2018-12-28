package configure.test.configurebuilds.activities.test106

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.content.res.AppCompatResources
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.animations.activity_animation106.*
import kotlinx.android.synthetic.animations.content_animation106.*


class Animation106Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation106)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list = mutableListOf<VectorImage>()
        list.add(VectorImage(R.drawable.mark))
        list.add(VectorImage(R.drawable.battery_charging))
        list.add(VectorImage(R.drawable.download))

        val adapter = Adapter(list)
        recycler_view.layoutManager = GridLayoutManager(this, 2)
        recycler_view.adapter = adapter
    }

    class VectorImage(val imageResources: Int)

    class Adapter(val list: List<VectorImage>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.single_vector_drawable, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.iv_vector_drawable.setImageDrawable(
                    AppCompatResources.getDrawable(holder.itemView.context, list[position].imageResources))
        }


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val iv_vector_drawable =
                    itemView.findViewById<ImageView>(R.id.iv_vector_drawable)!!
        }
    }

}
