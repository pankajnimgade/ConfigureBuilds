package configure.test.configurebuilds.activities.test101

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
import kotlinx.android.synthetic.recyclerView.activity_test101_vertical_scrollbar.*


class Test101VerticalScrollbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test101_vertical_scrollbar)
        setSupportActionBar(toolbar)

        initializeList()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeList() {

        val list = mutableListOf<TestItem>()
        for (index in 0..512) {
            list.add(TestItem("Position: $index"))
        }

        val adapter = TestItemAdapter(this, list)

        recycler_view.adapter = adapter

        recycler_view.layoutManager = object : LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State) {
                super.onLayoutChildren(recycler, state)
                //TODO if the items are filtered, considered hiding the fast scroller here
                val firstVisibleItemPosition = findFirstVisibleItemPosition()
                if (firstVisibleItemPosition != 0) {
                    // this avoids trying to handle un-needed calls
                    if (firstVisibleItemPosition == -1)
                    //not initialized, or no items shown, so hide fast-scroller
                        fastscroller.visibility = View.GONE
                    return
                }
                val lastVisibleItemPosition = findLastVisibleItemPosition()
                val itemsShown = lastVisibleItemPosition - firstVisibleItemPosition + 1
                //if all items are shown, hide the fast-scroller
                fastscroller.visibility = if (adapter.itemCount > itemsShown) View.VISIBLE else View.GONE
            }
        }

        fastscroller.setRecyclerView(recycler_view)
        fastscroller.setViewsToUse(R.layout.recycler_view_fast_scroller__fast_scroller, R.id.fastscroller_bubble, R.id.fastscroller_handle);
    }

    class TestItem(val text: String)

    class TestItemAdapter(val context: Context,
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

        fun getTextToShowInBubble(position: Int): String {

            val text = list[position].text

            return text.substring(text.length - 4, text.length)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val testItem = list[position]
            holder.testText.text = testItem.text
        }

        class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            val testText: TextView = itemView!!.findViewById(R.id.tv_text)
        }
    }
}
