package configure.test.configurebuilds.activities

import android.os.Bundle
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import configure.test.configurebuilds.R

import kotlinx.android.synthetic.main.activity_example.*

class ExampleActivity : AppCompatActivity() {

    private lateinit var horizontalScrollView: HorizontalScrollView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUI()
    }

    private fun initializeUI() {

        horizontalScrollView = findViewById(R.id.ExampleActivity_scrollToRight_HorizontalScrollView)
        textView = findViewById(R.id.ExampleActivity_scrollToRight_textView)

        horizontalScrollView.post {
            horizontalScrollView.fullScroll(View.FOCUS_RIGHT)
        }
    }

}
