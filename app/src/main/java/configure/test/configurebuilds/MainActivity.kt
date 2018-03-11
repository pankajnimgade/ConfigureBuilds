package configure.test.configurebuilds

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.TextView
import configure.test.configurebuilds.activities.ExampleActivity
import configure.test.configurebuilds.application.model.ActivityItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var listRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        initialize()
    }

    private fun initialize() {
        listRecyclerView = findViewById(R.id.MainActivity_activity_RecyclerView)
        listRecyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ActivityItemAdapter(this, ActivityItem.getActivityItemList())
        listRecyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    class ActivityItemAdapter(val context: Context,
                              val list: List<ActivityItem>) :
            RecyclerView.Adapter<ActivityItemAdapter.ActivityItemViewHolder>() {

        private val layoutInflater = LayoutInflater.from(context)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityItemViewHolder {
            val view = layoutInflater.inflate(R.layout.single_activity_item, parent, false)
            return ActivityItemViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ActivityItemViewHolder, position: Int) {
            val activityItem = list[position]
            holder.title.text = activityItem.activityName
            holder.rootLayout.setOnClickListener {
                context.startActivity(Intent(context, ExampleActivity::class.java))
            }
        }


        class ActivityItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            val rootLayout: CardView = itemView!!.findViewById(R.id
                    .single_activity_item_root_CardView)
            val title: TextView = itemView!!.findViewById(R.id.single_activity_item_name_textView)
        }
    }
}
