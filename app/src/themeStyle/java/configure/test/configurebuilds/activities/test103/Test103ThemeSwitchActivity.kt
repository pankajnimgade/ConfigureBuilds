package configure.test.configurebuilds.activities.test103

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.themeStyle.activity_test103_theme_switch.*

class Test103ThemeSwitchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test103_theme_switch)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
