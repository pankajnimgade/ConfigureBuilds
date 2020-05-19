package configure.test.configurebuilds.activities.test104

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import configure.test.configurebuilds.R
import configure.test.configurebuilds.databinding.ActivityRxJavaTest104JustBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxJavaTest104JustActivity : AppCompatActivity() {

    private val TAG = "RxJavaTest104Just"

    private lateinit var binding: ActivityRxJavaTest104JustBinding

    private lateinit var taskObservable: Observable<Task104>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rx_java_test104_just)

        studyRxJavaJust()
    }

    private fun studyRxJavaJust() {

        val taskList = Task104("Take out the trash", true, 3)

        taskObservable = Observable
                .just(taskList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }

    fun onAddSubscriber(view: View) {
        taskObservable.subscribe({
            Log.d(TAG, ": ${it.description}")
        }, {
            Log.d(TAG, ": onComplete was called")
        }, {
            Log.e(TAG, ": onError was called")
        })
    }
}
