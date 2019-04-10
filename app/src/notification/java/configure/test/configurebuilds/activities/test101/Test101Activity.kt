package configure.test.configurebuilds.activities.test101

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.notification.activity_test101.*

private val TAG = Test101Activity::class.java.simpleName

class Test101Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test101)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUi()
    }

    private fun initializeUi() {

        createNotificationChannel()
    }

    fun createNotification(view: View) {
        Log.d(TAG, ": createNotification")

        val builder = NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(android.R.drawable.ic_notification_clear_all)
                .setContentTitle("Basic Notification")
                .setContentText("This is test notification")
                .setStyle(NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line...\n" +
                                "Much longer text that cannot fit one line...\n" +
                                "Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(12, builder.build())
        }

    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
