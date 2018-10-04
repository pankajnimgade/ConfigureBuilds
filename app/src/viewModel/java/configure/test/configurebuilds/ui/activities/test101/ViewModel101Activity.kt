package configure.test.configurebuilds.ui.activities.test101

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.viewModel.activity_view_model101.*
import kotlinx.android.synthetic.viewModel.content_view_model101.*


class ViewModel101Activity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model101)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onResume() {
        super.onResume()
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel.init("12")

        initializeUi()
    }

    private fun initializeUi() {

        userViewModel.userLiveData.observe(this, Observer {
            first_name.text = it?.firstName
            last_name.text = it?.lastName
        })

    }

}
