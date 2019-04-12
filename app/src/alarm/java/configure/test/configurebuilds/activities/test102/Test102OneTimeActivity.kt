package configure.test.configurebuilds.activities.test102

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.util.Log
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.alarm.activity_test102_one_time.*

private val TAG = "Test102"

class Test102OneTimeActivity : AppCompatActivity() {
    private lateinit var mPendingIntent: PendingIntent
    private var alarmMgr: AlarmManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test102_one_time)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializePendingIntent()

        initializeUi()
    }

    private fun initializeUi() {

        btn_one_time_alarm.setOnClickListener {

            Log.d(TAG, ": ")

            alarmMgr = applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager

            alarmMgr?.set(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (60 * 1000),
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
