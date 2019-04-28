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
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import configure.test.configurebuilds.R
import configure.test.configurebuilds.activities.test101.RoomTest101Activity
import configure.test.configurebuilds.application.model.ActivityItem
import kotlinx.android.synthetic.room.activity_room_list.*
import kotlinx.android.synthetic.room.content_room_list.*

class RoomListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUi()
    }

    private fun initializeUi() {

        val list = mutableListOf<ActivityItem>();
        list.add(ActivityItem(RoomTest101Activity::class.java, "Test 101"))

        recycler_view.adapter = RoomAdapter(this, list)
    }

    class RoomAdapter(private val mContext: Context,
                      val list: List<ActivityItem>) :
            RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

        private val mLayoutInflater: LayoutInflater = LayoutInflater.from(mContext)


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = mLayoutInflater.inflate(R.layout.single_activity_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val activityItem = list[position]
            holder.activityName.text = activityItem.activityName
            holder.rootLayout.setOnClickListener {
                mContext.startActivity(Intent(mContext, activityItem.activityClass))
            }
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val rootLayout: CardView = itemView.findViewById(R.id
                    .single_activity_item_root_CardView)
            val activityName: TextView = itemView.findViewById(R.id
                    .single_activity_item_name_textView)
        }
    }
}
