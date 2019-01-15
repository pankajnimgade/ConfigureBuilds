package configure.test.configurebuilds.activities.test108

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.animations.activity_animation108.*
import kotlinx.android.synthetic.animations.content_animation108.*


class Animation108Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation108)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUi()
    }

    private fun initializeUi() {

        val list = listOf<Item108>(Item108("one...two...three..."),
                Item108("one...two...three..."),
                Item108("one...two...three..."),
                Item108("one...two...three..."),
                Item108("one...two...three..."),
                Item108("one...two...three..."),
                Item108("one...two...three..."))
        val adapter108 = Adapter108(list)

        recycler_view.adapter = adapter108

    }

}
