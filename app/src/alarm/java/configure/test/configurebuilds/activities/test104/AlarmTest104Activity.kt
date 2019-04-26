package configure.test.configurebuilds.activities.test104

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.alarm.activity_alarm_test104.*
import java.util.*


private val TAG = "AlarmTest104"

class AlarmTest104Activity : AppCompatActivity() {

    companion object {

        const val CHANNEL_ID = "CHANNEL_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_test104)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        initializeNotificationChannel()
    }


    fun repeatingAlarm(view: View) {

        Log.d(TAG, ": ")
        scheduleNotification()
    }

    private fun scheduleNotification() {

        Log.d(TAG, ": scheduleNotification()")

        val notificationIntent = Intent(this, NotificationPublisher::class.java)

        val pendingIntent = PendingIntent.getBroadcast(
                applicationContext, PendingIntent.FLAG_UPDATE_CURRENT,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val instance = Calendar.getInstance()

        alarmManager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                instance.timeInMillis + 1000,
                (1 * 60 * 1000),
                pendingIntent)


    }

    private fun getNotification(context: Context): Notification {

        Log.d(TAG, ": getNotification()")

        var builder = NotificationCompat.Builder(context, AlarmTest104Activity.CHANNEL_ID)
                .setSmallIcon(android.R.drawable.btn_plus)
                .setContentTitle("My notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        return builder.build()
    }


    private fun initializeNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            val name = "CHANNEL NAME"
            val descriptionText = "CHANNEL DESCRIPTION"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }
}
