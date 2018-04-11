package configure.test.configurebuilds.activities.dock.list

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.main.activity_test_dock_tile.*

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
        /* recyclerView = findViewById(R.id.TestDockTileActivity_dockTile_RecyclerView)
         recyclerView.layoutManager = LinearLayoutManager(applicationContext)*/
    }

}
