package configure.test.configurebuilds.activities.test105

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import configure.test.configurebuilds.R
import configure.test.configurebuilds.databinding.ActivityRxJava105RangeBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxJava105RangeActivity : AppCompatActivity() {

    private val TAG = "RxJava105Range"

    private lateinit var binding: ActivityRxJava105RangeBinding

    private lateinit var numberObservable: Observable<Int>
    private lateinit var taskObservable: Observable<Task105>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rx_java105_range)

        studyRxJavaRange103()
    }

    private fun studyRxJavaRange101() {
        numberObservable = Observable
                .range(0, 9)
                .subscribeOn(Schedulers.io())
                .map {
                    Log.d(TAG, ": Thread name : ${Thread.currentThread().name}")
                    return@map it
                }
                .observeOn(AndroidSchedulers.mainThread())
    }

    private fun studyRxJavaRange102() {
        taskObservable = Observable
                .range(0, 9)
                .subscribeOn(Schedulers.io())
                .map {
                    Log.d(TAG, ": Thread name : ${Thread.currentThread().name}")
                    return@map Task105("This is a task with priority : $it", false, it)
                }
                .takeWhile {
                    return@takeWhile it.priority < 5
                }
                .observeOn(AndroidSchedulers.mainThread())
    }

    private fun studyRxJavaRange103() {
        numberObservable = Observable
                .range(0, 9)
                .subscribeOn(Schedulers.io())
                .repeat(3)
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun addSubscriber(view: View) {
        val subscribe = numberObservable.subscribe {
            Log.d(TAG, ": Number: $it")
        }

     /*   taskObservable.subscribe {
            Log.d(TAG, ": Task : ${it.description}")
        }*/
    }
}
