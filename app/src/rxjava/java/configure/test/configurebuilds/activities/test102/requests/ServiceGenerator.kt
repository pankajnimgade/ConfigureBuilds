package configure.test.configurebuilds.activities.test102.requests

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pankaj Nimgade on 5/18/2020.
 */
class ServiceGenerator {

    companion object {

        private const val BASE_URL = "https://jsonplaceholder.typicode.com"

        private val retrofitBuilder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())

        private val retrofit = retrofitBuilder.build()

        private val requestApi = retrofit.create(RequestApi::class.java)

        fun getRequestApi(): RequestApi {
            return requestApi
        }
    }
}