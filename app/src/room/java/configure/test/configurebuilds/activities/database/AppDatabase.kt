package configure.test.configurebuilds.activities.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import configure.test.configurebuilds.activities.database.dao.UserDao
import configure.test.configurebuilds.activities.database.entities.User

/**
 * Created by Pankaj Nimgade on 4/27/2019.
 */
@Database(entities = [User::class], version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun roomUserDao(): UserDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        @JvmStatic
        fun getAppDatabase(application: Application): AppDatabase {

                INSTANCE = Room.databaseBuilder(application, AppDatabase::class.java,
                        "App_Database.db")
                        .addMigrations(MIGRATION_1_2)
                        .build()
            return INSTANCE as AppDatabase
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user ADD COLUMN email TEXT")
            }
        }

    }
}