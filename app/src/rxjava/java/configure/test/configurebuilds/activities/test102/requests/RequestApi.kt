package configure.test.configurebuilds.activities.test102.requests

import configure.test.configurebuilds.activities.test102.models.Comment
import configure.test.configurebuilds.activities.test102.models.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Pankaj Nimgade on 5/18/2020.
 */
interface RequestApi {

    @GET("posts")
    fun getPosts(): Observable<MutableList<Post>>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id") id: Int): Observable<MutableList<Comment>>

}