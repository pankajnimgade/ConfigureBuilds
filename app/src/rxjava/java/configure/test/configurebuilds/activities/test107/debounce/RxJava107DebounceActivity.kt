package configure.test.configurebuilds.activities.test107.debounce

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import configure.test.configurebuilds.R
import configure.test.configurebuilds.databinding.ActivityRxJava107DebounceBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

class RxJava107DebounceActivity : AppCompatActivity() {

    private val TAG = "RxJava107Debounce"

    private lateinit var binding: ActivityRxJava107DebounceBinding

    private val compositeDisposable = CompositeDisposable()

    private var timeSinceLastRequest: Long = System.currentTimeMillis()

    private val numberOfServerCalls = AtomicInteger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rx_java107_debounce)

        studyRxJavaDebounce()
    }

    private fun studyRxJavaDebounce() {

        val textObservable: Observable<String> = Observable.create<String> { emitter ->
            binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (!emitter.isDisposed) {
                        emitter.onNext(newText ?: "")
                    }
                    return false
                }
            })
        }
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


        val disposable = textObservable.subscribe({
            Log.d(TAG, ": OnNext time since last request: ${System.currentTimeMillis() - timeSinceLastRequest}")
            Log.d(TAG, ": OnNext search query is: $it ")
            numberOfServerCalls.incrementAndGet()
            timeSinceLastRequest = System.currentTimeMillis()
            sendRequestToServer()
        }, {
            Log.d(TAG, ": onComplete was called")
        }, {
            Log.e(TAG, ": onError was called")
        })
        compositeDisposable.add(disposable)
    }

    private fun sendRequestToServer() {
        binding.callsTextView.text = numberOfServerCalls.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
