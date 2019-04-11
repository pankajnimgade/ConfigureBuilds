package configure.test.configurebuilds.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import configure.test.configurebuilds.R
import configure.test.configurebuilds.activities.test101.Test101Activity
import configure.test.configurebuilds.activities.test102.ExpandableNotificationActivity
import configure.test.configurebuilds.application.model.ActivityItem
import kotlinx.android.synthetic.notification.activity_notification_list.*


class NotificationListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_list)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUi()
    }

    private fun initializeUi() {

        val list = mutableListOf<ActivityItem>()

        list.add(ActivityItem(Test101Activity::class.java, "Notification Test 101"))
        list.add(ActivityItem(ExpandableNotificationActivity::class.java, "Expandable Notification Test 102"))

        recycler_view.adapter = NotificationAdapter(this, list)
    }

    class NotificationAdapter(private val mContext: Context,
                              val list: List<ActivityItem>) :
            RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

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
