package configure.test.configurebuilds.activities.test103

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.themeStyle.activity_test103_theme_switch.*

class Test103ThemeSwitchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        delegate.localNightMode = ThemePreference.getInstance(application).getThemeMode()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test103_theme_switch)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.test103_change_theme, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.theme_light -> {
                Toast.makeText(applicationContext, "Light", Toast.LENGTH_SHORT).show()
                ThemePreference.getInstance(application).saveThemeMode(ThemeMode.DAY_LIGHT)
                recreate()
                true
            }
            R.id.theme_dark -> {
                Toast.makeText(applicationContext, "Dark", Toast.LENGTH_SHORT).show()
                ThemePreference.getInstance(application).saveThemeMode(ThemeMode.NIGHT_DARK)
                recreate()
                true
            }
            R.id.theme_system -> {
                ThemePreference.getInstance(application).saveThemeMode(ThemeMode.SYSTEM_AUTO)
                Toast.makeText(applicationContext, "System", Toast.LENGTH_SHORT).show()
                recreate()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}
