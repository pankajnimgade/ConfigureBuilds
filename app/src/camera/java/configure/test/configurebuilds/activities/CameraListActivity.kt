package configure.test.configurebuilds.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import configure.test.configurebuilds.R
import configure.test.configurebuilds.activities.test101.Camera101Activity
import configure.test.configurebuilds.application.model.ActivityItem
import configure.test.configurebuilds.databinding.ActivityCameraListBinding


class CameraListActivity : AppCompatActivity() {

    lateinit var binding: ActivityCameraListBinding

    private val list: MutableList<ActivityItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_camera_list)
        setSupportActionBar(binding.toolbar)

        initializeUi()
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeUi() {

        if (list.isEmpty()) {
            list.add(ActivityItem(Camera101Activity::class.java, "Camera 101"))
        }

        binding.recyclerView.adapter = CameraAdapter(this, list)
    }

    class CameraAdapter(val context: Context, val list: List<ActivityItem>) : RecyclerView.Adapter<CameraAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.single_activity_item, parent, false)
            val viewHolder = ViewHolder(view)

            viewHolder.rootView.setOnClickListener {
                val activityClass = list[viewHolder.adapterPosition].activityClass
                context.startActivity(Intent(context, activityClass))

            }
            return viewHolder
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.activityTitle.text = list[position].activityName
        }


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val rootView: CardView = itemView.findViewById(R.id.single_activity_item_root_CardView)
            val activityTitle: TextView = itemView.findViewById(R.id.single_activity_item_name_textView)
        }
    }
}
