package configure.test.configurebuilds.activities.test106.buffer

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import configure.test.configurebuilds.R
import configure.test.configurebuilds.databinding.ActivityRxJava106BufferBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxJava106BufferActivity : AppCompatActivity() {

    private val TAG = "RxJava106Buffer"

    private lateinit var binding: ActivityRxJava106BufferBinding

    private lateinit var taskObservable: Observable<Task106>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rx_java106_buffer)

        studyRxJavaBuffer101()
    }

    private fun studyRxJavaBuffer101() {
        taskObservable = Observable.fromIterable(DataSource106.createTaskList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun onAddSubscriber(view: View) {
        taskObservable
                .buffer(2)
                .subscribe({ it ->
                    Log.d(TAG, ": onNext was called")
                    Log.d(TAG, ": Task : ${it.size}")
                    it.forEach { Log.d(TAG, ": ${it.description}") }
                }, {
                    Log.d(TAG, ": onComplete was called")
                }, {
                    Log.e(TAG, ": onError was called")
                })
    }
}
