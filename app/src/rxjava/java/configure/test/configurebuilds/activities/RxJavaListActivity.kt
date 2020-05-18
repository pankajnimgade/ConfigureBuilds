package configure.test.configurebuilds.activities

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
import configure.test.configurebuilds.R
import configure.test.configurebuilds.activities.test101.RxJava101Activity
import configure.test.configurebuilds.activities.test102.RxJava102FlatMapActivity
import configure.test.configurebuilds.application.model.ActivityItem
import configure.test.configurebuilds.databinding.ActivityRxJavaListBinding
import kotlinx.android.synthetic.rxjava.activity_rx_java_list.*


class RxJavaListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRxJavaListBinding

    private val list: MutableList<ActivityItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rx_java_list)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUi()
    }

    private fun initializeUi() {

        if (list.isEmpty()) {
            list.add(ActivityItem(RxJava101Activity::class.java, "RxJava 101"))
            list.add(ActivityItem(RxJava102FlatMapActivity::class.java, "RxJava Flat Map 102"))
        }
        binding.recyclerView.adapter = RxJavaAdapter(list)
    }

    class RxJavaAdapter(val list: List<ActivityItem>) :
            RecyclerView.Adapter<RxJavaAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val rootView: CardView = itemView.findViewById(R.id.single_activity_item_root_CardView)
            val activityTitle: TextView = itemView.findViewById(R.id.single_activity_item_name_textView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val inflate = layoutInflater.inflate(R.layout.single_activity_item, parent, false)
            val viewHolder = ViewHolder(inflate)
            viewHolder.itemView.setOnClickListener {
                val activityClass = list[viewHolder.bindingAdapterPosition]
                parent.context?.let {
                    it.startActivity(Intent(it, activityClass.activityClass))
                }
            }

            return viewHolder
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val activityItem = list[position]
            holder.activityTitle.text = activityItem.activityName
        }
    }
}
