package configure.test.configurebuilds.ui.activities.test101

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import configure.test.configurebuilds.R
import configure.test.configurebuilds.databinding.ActivityDataBinding101Binding
import kotlinx.android.synthetic.dataBinding.activity_data_binding101.*


class DataBinding101Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDataBinding101Binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding101)
        setSupportActionBar(toolbar)

        val user = User.getInstance()
        binding.user = user
        binding.executePendingBindings()
        binding.notifyChange()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
