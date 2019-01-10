package configure.test.configurebuilds.activities.test102

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import configure.test.configurebuilds.R
import configure.test.configurebuilds.activities.test102.dagger.DaggerGotComponent
import kotlinx.android.synthetic.dagger.activity_dagger_test102.*
import kotlinx.android.synthetic.dagger.content_dagger_test102.*

/**
 * https://medium.com/@harivigneshjayapalan/dagger-2-for-android-beginners-dagger-2-part-i-f2de5564ab25
 * */
class DaggerTest102Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_test102)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUi()
    }

    private fun initializeUi() {

        val gotComponent = DaggerGotComponent.create()

        gotComponent.war.prepare()
        gotComponent.war.report()

        btn_boltons.setOnClickListener {

            gotComponent.war.getmBoltons().prepareForWar()
            gotComponent.war.getmBoltons().reportForWar()
        }

        btn_starks.setOnClickListener {

            gotComponent.war.getmStarks().prepareForWar()
            gotComponent.war.getmStarks().reportForWar()
        }

    }

}
