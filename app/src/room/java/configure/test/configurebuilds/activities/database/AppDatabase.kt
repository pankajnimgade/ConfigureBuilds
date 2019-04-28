package configure.test.configurebuilds.activities.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import configure.test.configurebuilds.activities.database.dao.UserDao
import configure.test.configurebuilds.activities.database.entities.User

/**
 * Created by Pankaj Nimgade on 4/27/2019.
 */
@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun roomUserDao(): UserDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        @JvmStatic
        fun getAppDatabase(application: Application): AppDatabase {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(application, AppDatabase::class.java,
                        "App_Database.db").build()
            }
            return INSTANCE as AppDatabase
        }

    }
}