package configure.test.configurebuilds.activities.test103

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.alarm.activity_alarm_test103.*
import java.util.*

private val TAG = "Test103"

/**
 * Wake up the device to fire the alarm at approximately 2:00 p.m., and repeat once a day at the same time:
 * */
class AlarmTest103Activity : AppCompatActivity() {

    private lateinit var mPendingIntent: PendingIntent
    private var alarmMgr: AlarmManager? = null

    // Set the alarm to start at approximately 2:00 p.m.
    val calendar: Calendar = Calendar.getInstance().apply {
        timeInMillis = System.currentTimeMillis()
        set(Calendar.HOUR_OF_DAY, 8)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_test103)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializePendingIntent()

        initializeUi()
    }

    private fun initializeUi() {

        btn_rtc_alarm.setOnClickListener {
            Log.d(TAG, ": ")

            alarmMgr = application.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmMgr?.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    AlarmManager.INTERVAL_DAY,
                    mPendingIntent
            )
        }
    }

    private fun initializePendingIntent() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gmail.com/"))
        mPendingIntent = PendingIntent.getActivity(this,
                1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }
}
