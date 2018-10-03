package configure.test.configurebuilds.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import configure.test.configurebuilds.R
import configure.test.configurebuilds.application.model.ActivityItem
import configure.test.configurebuilds.ui.activities.test101.ViewModel101Activity
import kotlinx.android.synthetic.viewModel.activity_view_model_list.*
import kotlinx.android.synthetic.viewModel.content_view_model_list.*


class ViewModelListActivity : AppCompatActivity() {

    lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        initializeUi()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeUi() {
        val list = mutableListOf<ActivityItem>()
        list.add(ActivityItem(ViewModel101Activity::class.java, "View Model 101"))
        recycler_view.adapter = Adapter(list)

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

        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

            var mTitleText: TextView = itemView?.findViewById(R.id.single_activity_item_name_textView)!!
        }
    }

}
