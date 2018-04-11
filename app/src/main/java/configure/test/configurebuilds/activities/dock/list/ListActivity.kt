package configure.test.configurebuilds.activities.dock.list

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        initializeUI()
    }

    private fun initializeUI() {
        recyclerView = findViewById(R.id.ListActivity_list_RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val list = ArrayList<ListItem>()
        list.add(ListItem("first1", "second1"))
        list.add(ListItem("first2", "second2"))

        val adapter = MyAdapter(this, list)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    private class MyAdapter(val context: Context, val list: List<ListItem>) :
            RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        private val mLayoutInflater = LayoutInflater.from(context)


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = mLayoutInflater.inflate(R.layout.single_dock_title_item, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentItem = list[position]
            holder.firstTitleTextView.text = currentItem.firstTitle
            holder.secondTitleTextView.text = currentItem.secondTitle
        }


        private class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

            val firstTitleTextView = itemView!!.findViewById<TextView>(R.id
                    .single_dock_title_first_textView)
            val secondTitleTextView = itemView!!.findViewById<TextView>(R.id
                    .single_dock_title_second_textView)
        }
    }

    private class ListItem(val firstTitle: String, val secondTitle: String)
}
