package configure.test.configurebuilds.activities.test102.models

/**
 * Created by Pankaj Nimgade on 5/18/2020.
 */
data class Post(val userId: Int,
                val id: Int,
                val title: String,
                val body: String,
                val comments: List<Comment>)