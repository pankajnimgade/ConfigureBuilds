package configure.test.configurebuilds.ui.activities.test103

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import configure.test.configurebuilds.R
import configure.test.configurebuilds.databinding.ActivityEventHandlerBinding

class EventHandlerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityEventHandlerBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_event_handler)
        binding.eventHandler = EventHandler()

        val person = Person(firstName = "John", lastName = "Smith")
        val information = Information(phoneNumber = "01684358", emailAddress = "pankaj.nimgade@gmail.com")
        val contact = Contact(person = person, information = information)
        binding.contact = contact
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
