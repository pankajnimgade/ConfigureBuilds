package configure.test.configurebuilds.activities.dock.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import configure.test.configurebuilds.R
import configure.test.configurebuilds.activities.dock.list.RecyclerSectionItemDecoration.SectionCallback
import kotlinx.android.synthetic.main.activity_test_dock_tile.*

/**
 * http://www.codexpedia.com/android/android-recyclerview-with-sticky-header-using-itemdecoration/
 * */
class TestDockTileActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_dock_tile)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUI()
    }

    private fun initializeUI() {
        recyclerView = findViewById(R.id.TestDockTileActivity_dockTile_RecyclerView)
        val list = ArrayList<MyListItem>()
        initializeList(list)
        val adapter = MyAdapter(this, list)
        recyclerView.adapter = adapter

        val sectionItemDecoration = RecyclerSectionItemDecoration(resources.getDimensionPixelSize
        (android.R.dimen.app_icon_size),
                true,
                getSectionCallback(list))

        recyclerView.addItemDecoration(sectionItemDecoration)
    }

    private fun initializeList(list: ArrayList<MyListItem>) {
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
        list.add(MyListItem("one", "Two"))
    }

    private fun getSectionCallback(list: ArrayList<MyListItem>): SectionCallback {

        return object : SectionCallback {
            override fun isSection(position: Int): Boolean {
                return position == 0 || list[position].firstName[0] != list[position-1]
                        .secondName[0]
            }

            override fun getSectionHeader(position: Int): CharSequence {
                return list[position].firstName.subSequence(0,1)
            }
        }
    }

    private class MyAdapter(mContext: Context, val list: List<MyListItem>) :
            RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        val mLayoutInflater = LayoutInflater.from(mContext)!!

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(mLayoutInflater.inflate(
                    R.layout.single_dock_title_item, parent, false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentMyListItem = list[position]
            holder.firstNameTextView.text = currentMyListItem.firstName
            holder.secondNameTextView.text = currentMyListItem.secondName
        }

        private class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

            val firstNameTextView = itemView!!.findViewById<TextView>(R.id
                    .single_dock_title_first_textView)
            val secondNameTextView = itemView!!.findViewById<TextView>(R.id
                    .single_dock_title_second_textView)
        }
    }

    class MyListItem(val firstName: String, val secondName: String)
}