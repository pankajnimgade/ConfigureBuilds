package configure.test.configurebuilds.activities.test101

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import configure.test.configurebuilds.R
import configure.test.configurebuilds.StartUp
import configure.test.configurebuilds.activities.database.AppDatabase
import configure.test.configurebuilds.activities.database.dao.UserDao
import configure.test.configurebuilds.activities.database.entities.User
import kotlinx.android.synthetic.room.activity_room_test101.*
import kotlinx.android.synthetic.room.content_room_test101.*
import java.util.*
import kotlin.collections.ArrayList

class RoomTest101Activity : AppCompatActivity() {

    private lateinit var mAppDatabase: AppDatabase

    companion object {

        private val TAG = RoomTest101Activity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_test101)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeInstanceVariables()
        initializeUi()
    }

    private fun initializeUi() {

        mAppDatabase = AppDatabase.getAppDatabase(application)

        val userList = mAppDatabase.roomUserDao().getAll()

        var list = ArrayList<User>()

        val userAdapter = UserAdapter(this, list)
        recycler_view.adapter = userAdapter

        userList.observe(this, androidx.lifecycle.Observer {

            Log.d(TAG, ": ${it.size}")
            userAdapter.addItem(it)
        })
    }

    private fun initializeInstanceVariables() {

        mAppDatabase = (application as StartUp).appDatabase
    }

    fun saveUser(view: View) {
        Log.d(TAG, ":saveUser() ")
        val id = (Random().nextInt(100)) + (Random().nextInt(100)) +(Random().nextInt(100))

        InsertUser(mAppDatabase.roomUserDao()).execute((User(id = (Random().nextInt(100)), firstName = "first $id", lastName = "last $id")))
    }

    class UserAdapter(mContext: Context, var list: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

        private val mLayoutInflater: LayoutInflater = LayoutInflater.from(mContext)


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = mLayoutInflater.inflate(R.layout.single_user_item_layout, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val user = list[position]
            holder.tvUser.text = "${user.firstName} ${user.lastName}"

        }

        fun addItem(user: List<User>) {
            list.addAll(user)
            notifyDataSetChanged()
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val tvUser: TextView = itemView.findViewById(R.id.tv_user)
        }
    }

    class InsertUser(private val userDao: UserDao) : AsyncTask<User, Void, Void>() {

        override fun doInBackground(vararg params: User?): Void? {

            params[0]?.let { this.userDao.insertAll(it) }

            return null
        }

    }

}
