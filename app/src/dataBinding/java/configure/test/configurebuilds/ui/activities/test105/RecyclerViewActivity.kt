package configure.test.configurebuilds.ui.activities.test105

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.dataBinding.activity_recycler_view.*
import kotlinx.android.synthetic.dataBinding.content_recycler_view.*


class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUi()
    }

    private fun initializeUi() {

        val personList = mutableListOf<Person>()
        personList.add(Person("first", "last"))
        personList.add(Person("first", "last"))
        personList.add(Person("first", "last"))
        personList.add(Person("first", "last"))
        personList.add(Person("first", "last"))

        val adapter = PersonAdapter(personList)

        recycler_view.adapter = adapter
    }

}
