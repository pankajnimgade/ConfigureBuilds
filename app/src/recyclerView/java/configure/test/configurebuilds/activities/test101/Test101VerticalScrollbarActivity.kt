package configure.test.configurebuilds.activities.test101

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.recyclerView.activity_test101_vertical_scrollbar.*


class Test101VerticalScrollbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test101_vertical_scrollbar)
        setSupportActionBar(toolbar)

        initializeList()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeList() {

        val list = mutableListOf<TestItem>()
        for (index in 0..512) {
            list.add(TestItem("Position: $index"))
        }

        val adapter = TestItemAdapter(this, list)

        recycler_view.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    private class TestItem(val text: String)

    private class TestItemAdapter(val context: Context,
                                  val list: List<TestItem>) :
            RecyclerView.Adapter<TestItemAdapter.MyViewHolder>() {

        private val mLayoutInflater: LayoutInflater = LayoutInflater.from(context)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(mLayoutInflater.inflate(R.layout.single_test_item, parent,
                    false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val testItem = list[position]
            holder.testText.text = testItem.text
        }

        private class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            val testText: TextView = itemView!!.findViewById(R.id.tv_text)
        }
    }
}
