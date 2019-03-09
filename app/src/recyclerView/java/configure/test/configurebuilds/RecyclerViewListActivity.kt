package configure.test.configurebuilds

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import configure.test.configurebuilds.activities.test101.Test101VerticalScrollbarActivity
import configure.test.configurebuilds.application.model.ActivityItem
import kotlinx.android.synthetic.recyclerView.activity_recycler_view_list.*
import kotlinx.android.synthetic.recyclerView.content_recycler_view_list.*


class RecyclerViewListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_list)
        setSupportActionBar(toolbar)

        initializeUi()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeUi() {

        val list: MutableList<ActivityItem> = mutableListOf()

        list.add(ActivityItem(Test101VerticalScrollbarActivity::class.java, "Vertical ScrollView 101"))

        val adapter = ListAdapter(this, list)

        recycler_view.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    private class ListAdapter(val context: Context,
                              val list: List<ActivityItem>) :
            RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

        private val mLayoutInflater: LayoutInflater = LayoutInflater.from(context);

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(mLayoutInflater.inflate(R.layout.single_activity_item, parent,
                    false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val activityItem = list[position]
            holder.activityName.text = activityItem.activityName
            holder.rootLayout.setOnClickListener {
                context.startActivity(Intent(context, activityItem.activityClass))
            }
        }

        private class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            val rootLayout: ViewGroup = itemView!!.findViewById(R.id.single_activity_item_root_CardView)
            val activityName: TextView = itemView!!.findViewById(R.id
                    .single_activity_item_name_textView)
        }
    }

}
