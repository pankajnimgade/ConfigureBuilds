package configure.test.configurebuilds.activities.test109

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.animations.activity_animation109.*


class Animation109Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation109)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
