package configure.test.configurebuilds.activities.test103

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import configure.test.configurebuilds.R
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxJava103JustActivity : AppCompatActivity() {

    private val TAG = "RxJava103Just"

    lateinit var taskObservable: Observable<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java103_just)

        studyRxJava()
    }

    private fun studyRxJava() {
//        val task = Task("Walk the dog", false, 3)

        val taskList : List<Task> = DataSource.createTaskList()

        taskObservable = Observable.create(ObservableOnSubscribe<Task> { emitter ->
            Log.d(TAG, ": Someone has subscribed to this observable...")

            taskList.forEach {
                if (!emitter.isDisposed) {
                    emitter.onNext(it)
                }
            }
            if (!emitter.isDisposed) {
                emitter.onComplete()
            }

        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }

    fun onAddSubscriber(view: View) {
        taskObservable.subscribe({
            Log.d(TAG, ": onNext was called")
            Log.d(TAG, ": Task : ${it.description}")
        }, {
            Log.d(TAG, ": onComplete was called")
        }, {
            Log.e(TAG, ": onError was called")
        })
    }
}
