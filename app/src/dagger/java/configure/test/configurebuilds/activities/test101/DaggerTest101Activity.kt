package configure.test.configurebuilds.activities.test101

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import configure.test.configurebuilds.R
import configure.test.configurebuilds.activities.test101.dagger.DaggerDateComponent
import configure.test.configurebuilds.activities.test101.dagger.DateComponent
import kotlinx.android.synthetic.dagger.activity_dagger_test101.*
import kotlinx.android.synthetic.dagger.content_dagger_test101.*
import java.text.SimpleDateFormat
import java.util.*


/**
 * https://proandroiddev.com/how-to-dagger-2-with-android-part-1-18b5b941453f
 * */
class DaggerTest101Activity : AppCompatActivity() {

    lateinit var dateComponent: DateComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_test101)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dateComponent = DaggerDateComponent.create()

        initializeUi()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun initializeUi() {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val format = sdf.format(dateComponent.dateStore.date)
        tv_date.text = format
    }

}
