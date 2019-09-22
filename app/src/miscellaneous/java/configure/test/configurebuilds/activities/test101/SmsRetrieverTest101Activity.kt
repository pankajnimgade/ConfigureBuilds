package configure.test.configurebuilds.activities.test101

import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.miscellaneous.activity_sms_retriever_test101.*

private val TAG = "SMS_RETRIEVER"

class SmsRetrieverTest101Activity : AppCompatActivity() {

    private val smsBroadcast = MySMSBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_retriever_test101)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        startSmsRetriever()

        initializeText()
    }

    private fun initializeText() {

        val message = "<#> Your code is: ${OtpGenerator.getCode()}\n" +
                "${AppSignatureHelper(applicationContext).appSignatures[0]}"
        tv_generated_message.text = message

        tv_hash_code.text = AppSignatureHelper(applicationContext).appSignatures[0]
    }

    private fun startSmsRetriever() {

        // Get an instance of SmsRetrieverClient, used to start listening for a matching
        // SMS message.
        val client = SmsRetriever.getClient(this /* context */)

        // Starts SmsRetriever, which waits for ONE matching SMS message until timeout
        // (5 minutes). The matching SMS message will be sent via a Broadcast Intent with
        // action SmsRetriever#SMS_RETRIEVED_ACTION.
        val task = client.startSmsRetriever()

        // Listen for success/failure of the start Task. If in a background thread, this
        // can be made blocking using Tasks.await(task, [timeout]);
        task.addOnSuccessListener(OnSuccessListener<Void> {
            // Successfully started retriever, expect broadcast intent
            // ...
            Log.d(TAG, ": addOnSuccessListener()")
            Toast.makeText(this, " Started listening...", Toast.LENGTH_LONG).show()
            tv_status.text = "Waiting for the OTP"

            registerReceiver(smsBroadcast, IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION))

            listenSms()
        })

        task.addOnFailureListener(OnFailureListener {
            // Failed to start retriever, inspect Exception for more details
            // ...
            Log.d(TAG, ": addOnFailureListener()")
            tv_status.text = "Cannot Start SMS Retriever"

        })
    }

    private fun listenSms() {
        MySMSBroadcastReceiver.bindListener(object : MySMSBroadcastReceiver.OTPReceiveListener {
            override fun onOTPReceived(code: String) {
                Log.d(TAG, "onOTPReceived(): $code")
//                etCode.setText(code)
            }

            override fun onOTPTimeOut() {
                Log.d(TAG, "onOTPTimeOut(): ")
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(smsBroadcast)
    }
}
