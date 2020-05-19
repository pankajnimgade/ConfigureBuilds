package configure.test.configurebuilds.activities.test102.models

/**
 * Created by Pankaj Nimgade on 5/18/2020.
 */
data class Post(var userId: Int,
                var id: Int,
                var title: String,
                var body: String,
                var comments: MutableList<Comment> = mutableListOf())