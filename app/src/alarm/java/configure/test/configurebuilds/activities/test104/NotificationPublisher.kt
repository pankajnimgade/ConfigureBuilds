package configure.test.configurebuilds.activities.test104

import android.app.Notification
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.util.Log
import java.util.*


/**
 * Created by Pankaj Nimgade on 4/25/2019.
 */

private const val TAG = "NotificationPub"

class NotificationPublisher : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Log.d(TAG, ": onReceive()")
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify((Random().nextInt(100)), getNotification(context))

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
}