package configure.test.configurebuilds.ui.activities.test104

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.View
import configure.test.configurebuilds.R
import configure.test.configurebuilds.databinding.ActivityObservableBinding
import kotlinx.android.synthetic.dataBinding.activity_observable.*
import java.util.*


class ObservableActivity : AppCompatActivity() {

    var observeUser: ObserveUser? = null

    companion object {

        private val TAG = ObservableActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityObservableBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_observable)
        observeUser = ObserveUser()
        binding.observerUser = observeUser

        observeUser?.age?.set(22)
        observeUser?.firstName?.set("Pankaj")
        observeUser?.lastName?.set("Nimgade")

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun changeNumber(view: View) {
        Log.d(TAG, ": ChangeNumber")
        observeUser?.random?.set(Random().nextInt(25))
    }
}
