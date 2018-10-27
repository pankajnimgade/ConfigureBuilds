package configure.test.configurebuilds.ui.activities.test102

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import configure.test.configurebuilds.R
import configure.test.configurebuilds.databinding.ActivityExpression102Binding
import kotlinx.android.synthetic.dataBinding.activity_expression102.*


class Expression102Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityExpression102Binding = DataBindingUtil.setContentView(this, R.layout.activity_expression102)

        val expression = Expression()
        binding.expression = expression

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
