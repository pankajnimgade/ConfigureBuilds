package configure.test.configurebuilds.activities.test104

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.alarm.activity_alarm_test104.*

private val TAG = "AlarmTest104"

class AlarmTest104Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_test104)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun repeatingAlarm(view: View) {

        Log.d(TAG, ": ")
    }
}
