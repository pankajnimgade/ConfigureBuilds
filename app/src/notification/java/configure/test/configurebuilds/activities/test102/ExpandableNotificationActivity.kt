package configure.test.configurebuilds.activities.test102

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.app.Person
import android.support.v7.app.AppCompatActivity
import android.view.View
import configure.test.configurebuilds.R
import java.util.*


private const val CHANNEL_ID = "EXPANDABLE_CHANNEL_ID"

class ExpandableNotificationActivity : AppCompatActivity() {

    private lateinit var gokuBitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_notification)

        gokuBitmap = BitmapFactory.decodeResource(resources,
                R.drawable.goku_thumb_nail)
        createNotificationChannel()
    }

    fun bigTextNotification(view: View) {

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_menu_search)
                .setContentTitle("Search title")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..." +
                                "Much longer text that cannot fit one line..." +
                                "Much longer text that cannot fit one line..."))
                .setShowWhen(false)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        with(NotificationManagerCompat.from(this)) {

            notify(12, builder.build())
        }
    }

    fun expandableImageNotification(view: View) {

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_menu_manage)
                .setContentTitle("Goku")
                .setContentText("Goku image")
                .setLargeIcon(gokuBitmap)
                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(gokuBitmap).bigLargeIcon(null))
                .build()

        with(NotificationManagerCompat.from(this)) {

            notify(12, notification)
        }
    }

    fun largeBlockOfTextNotification(view: View) {

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.stat_sys_headset)
                .setContentTitle("Word")
                .setContentText("Meaning of the word")
                .setLargeIcon(gokuBitmap)
                .setStyle(NotificationCompat.BigTextStyle()
                        .bigText("Synonym\nvery large text over here" +
                                "This could be a very large text over here" +
                                "\nAntonym\nlarge text over here" +
                                "This could be a very large text over here"))
                .build()


        with(NotificationManagerCompat.from(this)) {

            notify(12, notification)
        }
    }

    fun conversationNotification(view: View) {

        val synonyms = Person.Builder().setName("Synonyms").setIcon(null).setBot(false).build()
        val antonyms = Person.Builder().setName("Antonyms").setIcon(null).setBot(false).build()

        val message1 =
                NotificationCompat.MessagingStyle.Message("Ecstasy, Happiness, Heaven",
                        Calendar.getInstance().timeInMillis,
                        synonyms)

        val message2 =
                NotificationCompat.MessagingStyle.Message("Misery, Sadness, Trouble",
                        Calendar.getInstance().timeInMillis,
                        antonyms)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_map)
                .setContentTitle("Nirvana")
                .setShowWhen(false)
                .setContentText("Meaning of the word")
                .setStyle(NotificationCompat.MessagingStyle("")
                        .addMessage(message1)
                        .addMessage(message2))
                .build()


        with(NotificationManagerCompat.from(this)) {

            notify(12, notification)
        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
