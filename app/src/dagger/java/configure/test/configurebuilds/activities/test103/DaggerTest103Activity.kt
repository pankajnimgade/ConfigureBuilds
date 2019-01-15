package configure.test.configurebuilds.activities.test103

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.dagger.activity_dagger_test103.*


/**
 * https://medium.com/@Zhuinden/that-missing-guide-how-to-use-dagger2-ef116fbea97
 * */
class DaggerTest103Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_test103)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
