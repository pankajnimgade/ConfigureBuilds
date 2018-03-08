package configure.test.submodulemylibrary

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.squareup.okhttp.OkHttpClient
import kotlinx.android.synthetic.main.activity_sub_module_main.*

class SubModuleMainActivity : AppCompatActivity() {

    lateinit var helloTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_module_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        initializeUI()
    }

    private fun initializeUI() {
        val okHttp: OkHttpClient = OkHttpClient()

    }

}
