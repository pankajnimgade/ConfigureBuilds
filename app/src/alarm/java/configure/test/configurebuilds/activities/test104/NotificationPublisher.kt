package configure.test.configurebuilds.activities.test104

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


/**
 * Created by Pankaj Nimgade on 4/25/2019.
 */

private const val TAG = "NotificationPub"

class NotificationPublisher : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Log.d(TAG, ": onReceive()")


        with(NotificationManagerCompat.from(context)) {
            notify(0, getNotification(context))
        }

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