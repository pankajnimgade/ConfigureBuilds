package configure.test.configurebuilds.activities.test101

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.search.activity_search_test101.*

private const val TAG = "SEARCHABLE_101"

class Searchable101Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchable101)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        checkIfSearchIntent()

    }

    private fun checkIfSearchIntent() {

        // Verify action and get query
        if (intent.action == Intent.ACTION_SEARCH) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                doMySearch(query)
            }
        }
    }

    private fun doMySearch(query: String) {


        Log.d(TAG, ": $query")
    }
}
