package configure.test.configurebuilds.activities

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
import configure.test.configurebuilds.activities.test101.DaggerTest101Activity
import configure.test.configurebuilds.activities.test102.DaggerTest102Activity
import configure.test.configurebuilds.activities.test103.DaggerTest103Activity
import configure.test.configurebuilds.application.model.ActivityItem
import kotlinx.android.synthetic.dagger.activity_dagger_list.*
import kotlinx.android.synthetic.dagger.content_dagger_list.*


class DaggerListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUi()
    }

    private fun initializeUi() {

        var list = mutableListOf<ActivityItem>()

        list.add(ActivityItem(DaggerTest101Activity::class.java, "Dagger Test 101"))
        list.add(ActivityItem(DaggerTest102Activity::class.java, "Dagger Test 102"))
        list.add(ActivityItem(DaggerTest103Activity::class.java, "Dagger Test 103"))

        recycler_view.adapter = DaggerAdapter(this, list)
    }

    class DaggerAdapter(private val mContext: Context,
                        val list: List<ActivityItem>) :
            RecyclerView.Adapter<DaggerAdapter.ViewHolder>() {

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
