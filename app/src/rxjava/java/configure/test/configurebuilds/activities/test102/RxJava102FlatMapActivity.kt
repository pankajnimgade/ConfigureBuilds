package configure.test.configurebuilds.activities.test102

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import configure.test.configurebuilds.R
import configure.test.configurebuilds.databinding.ActivityRxJava102FlatMapBinding

class RxJava102FlatMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRxJava102FlatMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rx_java102_flat_map)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initializeUi()
    }

    private fun initializeUi() {

    }
}
