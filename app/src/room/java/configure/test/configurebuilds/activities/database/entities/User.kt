package configure.test.configurebuilds.activities.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Pankaj Nimgade on 4/27/2019.
 */
@Entity(tableName = "user")
class User(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: Int,
        @ColumnInfo(name = "first_name") val firstName: String?,
        @ColumnInfo(name = "last_name") val lastName: String?,
        @ColumnInfo(name = "email") val email: String? = "me@gmail.com"
)