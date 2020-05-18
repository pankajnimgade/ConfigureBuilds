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
                .observeOn(AndroidSchedulers.mainThread())

        taskObservable.subscribe({
            Log.d("RxJavaApp", "onNext() ${Thread.currentThread().name}")
            Log.d("RxJavaApp", "onNext() ${it.description}")
        }, {
            Log.e("RxJavaApp", "OnError was called")
        }, {
            Log.d("RxJavaApp", "OnComplete was called")
        })
    }
}
