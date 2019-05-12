package configure.test.configurebuilds.activities.test102

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.userInterface.activity_test102_theme.*

class Test102ThemeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test102_theme)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
