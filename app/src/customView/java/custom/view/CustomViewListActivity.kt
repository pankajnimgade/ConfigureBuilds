package custom.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import configure.test.configurebuilds.R
import configure.test.configurebuilds.application.model.ActivityItem
import custom.view.activities.test101.Custom101Activity
import kotlinx.android.synthetic.customView.activity_custom_view_list.*


class CustomViewListActivity : AppCompatActivity() {

    private val list: MutableList<ActivityItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view_list)
        setSupportActionBar(toolbar)

        initializeUi()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeUi() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        if (list.isEmpty()) {
            list.add(ActivityItem(Custom101Activity::class.java, "Custom 101"))
        }
        recyclerView.adapter = CustomViewAdapter(this, list)


    }

    class CustomViewAdapter(val mContext: Context,
                            val list: List<ActivityItem>) :
            RecyclerView.Adapter<CustomViewAdapter.ViewHolder>() {

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

        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            val rootLayout: CardView = itemView!!.findViewById(R.id
                    .single_activity_item_root_CardView)
            val activityName: TextView = itemView!!.findViewById(R.id
                    .single_activity_item_name_textView)
        }
    }
}
