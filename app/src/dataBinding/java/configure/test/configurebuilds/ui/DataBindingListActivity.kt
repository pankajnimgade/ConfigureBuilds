package configure.test.configurebuilds.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import configure.test.configurebuilds.R
import configure.test.configurebuilds.application.model.ActivityItem
import configure.test.configurebuilds.ui.activities.test101.DataBinding101Activity
import configure.test.configurebuilds.ui.activities.test102.Expression102Activity
import configure.test.configurebuilds.ui.activities.test103.EventHandlerActivity
import configure.test.configurebuilds.ui.activities.test104.ObservableActivity
import configure.test.configurebuilds.ui.activities.test105.RecyclerViewActivity
import kotlinx.android.synthetic.dataBinding.activity_data_binding_list.*
import kotlinx.android.synthetic.dataBinding.content_data_binding_list.*


class DataBindingListActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUi()
    }

    private fun initializeUi() {
        val list = mutableListOf<ActivityItem>()
        list.add(ActivityItem(DataBinding101Activity::class.java, "Data Binding 101"))
        list.add(ActivityItem(Expression102Activity::class.java, "Expression 102"))
        list.add(ActivityItem(EventHandlerActivity::class.java, "Event Handler 103"))
        list.add(ActivityItem(ObservableActivity::class.java, "Observable Activity 104"))
        list.add(ActivityItem(RecyclerViewActivity::class.java, "RecyclerView Activity 105"))
        recycler_view_list.adapter = Adapter(list)
    }

    override fun onResume() {
        super.onResume()

    }

    class Adapter(val mList: List<ActivityItem>) : RecyclerView.Adapter<Adapter.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_activity_item, parent, false))
        }

        override fun getItemCount(): Int {
            return mList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val mActivityItem: ActivityItem = mList[position]
            holder.mTitleText.text = mActivityItem.activityName
            holder.itemView.setOnClickListener {
                val intent: Intent = Intent(holder.itemView.context, mActivityItem.activityClass)
                holder.itemView.context.startActivity(intent)
            }
        }

        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

            var mTitleText: TextView = itemView?.findViewById(R.id.single_activity_item_name_textView)!!
        }
    }

}
