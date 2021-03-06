package configure.test.configurebuilds.activities.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import configure.test.configurebuilds.activities.database.entities.User

/**
 * Created by Pankaj Nimgade on 4/27/2019.
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}