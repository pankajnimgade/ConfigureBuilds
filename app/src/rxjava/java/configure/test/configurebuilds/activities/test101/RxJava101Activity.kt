package configure.test.configurebuilds.activities.test101

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import configure.test.configurebuilds.R
import configure.test.configurebuilds.databinding.ActivityRxJava101Binding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class RxJava101Activity : AppCompatActivity() {

    private val TAG = RxJava101Activity::class.java.simpleName

    lateinit var binding: ActivityRxJava101Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rx_java101)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initializeUi()
    }

    private fun initializeUi() {
        val taskObservable: Observable<Task> = Observable
                .fromIterable(DataSource.createTaskList())
                .subscribeOn(Schedulers.io())
                .filter {
                    Log.d(TAG, ": ${Thread.currentThread().name}")
                    Thread.sleep(1000)
                    return@filter it.isCompleted
                }
                .observeOn(AndroidSchedulers.mainThread())

        taskObservable.subscribe({
            Log.d(TAG, "onNext() ${Thread.currentThread().name}")
            Log.d(TAG, "onNext() ${it.description}")
        }, {
            Log.e(TAG, "OnError was called")
        }, {
            Log.d(TAG, "OnComplete was called")
        })
    }
}
