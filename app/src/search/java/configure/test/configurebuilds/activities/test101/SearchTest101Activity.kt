package configure.test.configurebuilds.activities.test101

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.search.activity_search_test101.*

private const val TAG = "SEARCH_TEST_101"

class SearchTest101Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_test101)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn_start_searchable.setOnClickListener {
            startActivity(Intent(this, Searchable101Activity::class.java))
        }

        onSearchRequested()

    }


}
