package configure.test.configurebuilds.activities.test101

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.alarm.activity_alarm_test101.*

private val TAG = "Test101"

/**
 * Wake up the device to fire the alarm in 30 minutes, and every 30 minutes after that:
 * */
class AlarmTest101Activity : AppCompatActivity() {

    private lateinit var mPendingIntent: PendingIntent
    private var alarmMgr: AlarmManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_test101)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializePendingIntent()

        initializeUi()
    }

    private fun initializePendingIntent() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
        mPendingIntent = PendingIntent.getActivity(this,
                1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    private fun initializeUi() {

        btn_1_alarm.setOnClickListener {
            alarmMgr = baseContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmMgr?.setInexactRepeating(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1 * 60 * 1000),
                    AlarmManager.INTERVAL_HALF_HOUR,
                    mPendingIntent
            )
        }
    }
}
