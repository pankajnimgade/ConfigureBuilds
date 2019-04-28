package configure.test.configurebuilds.activities.test101

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import configure.test.configurebuilds.R
import configure.test.configurebuilds.StartUp
import configure.test.configurebuilds.activities.database.AppDatabase
import configure.test.configurebuilds.activities.database.dao.UserDao
import configure.test.configurebuilds.activities.database.entities.User
import kotlinx.android.synthetic.room.activity_room_test101.*
import java.util.*

class RoomTest101Activity : AppCompatActivity() {

    private lateinit var mAppDatabase: AppDatabase

    companion object {

        private val TAG = RoomTest101Activity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_test101)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeInstanceVariables()
    }

    private fun initializeInstanceVariables() {

        mAppDatabase = (application as StartUp).appDatabase
    }

    fun saveUser(view: View) {
        Log.d(TAG, ":saveUser() ")

        InsertUser(mAppDatabase.roomUserDao()).execute((User(id = (Random().nextInt(100)), firstName = "first", lastName = "last")))
    }

    class InsertUser(val userDao: UserDao) : AsyncTask<User, Void, Void>() {

        override fun doInBackground(vararg params: User?): Void? {

            params[0]?.let { this.userDao.insertAll(it) }

            return null
        }

    }

}
