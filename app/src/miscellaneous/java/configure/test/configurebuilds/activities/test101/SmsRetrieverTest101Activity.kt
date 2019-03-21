package configure.test.configurebuilds.activities.test101

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.miscellaneous.activity_sms_retriever_test101.*

class SmsRetrieverTest101Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_retriever_test101)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }
}
