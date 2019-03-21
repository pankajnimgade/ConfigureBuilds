package configure.test.configurebuilds.activities.test101

import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.miscellaneous.activity_sms_retriever_test101.*

private val TAG = "SMS_RETRIEVER"

class SmsRetrieverTest101Activity : AppCompatActivity(),
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        MySMSBroadcastReceiver.OTPReceiveListener {

    var mCredentialsApiClient: GoogleApiClient? = null
    private val KEY_IS_RESOLVING = "is_resolving"
    private val RC_HINT = 2
    private var otpReceiver: MySMSBroadcastReceiver.OTPReceiveListener = this

    private val smsBroadcast = MySMSBroadcastReceiver()

    override fun onConnected(p0: Bundle?) {

    }

    override fun onConnectionSuspended(p0: Int) {
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
    }

    override fun onOTPReceived(otp: String) {
        Log.d(TAG, ": onOTPReceived(): $otp")
    }

    override fun onOTPTimeOut() {
        Log.d(TAG, ": onOTPTimeOut()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_retriever_test101)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mCredentialsApiClient = GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .enableAutoManage(this, this)
                .addApi(Auth.CREDENTIALS_API)
                .build()

        startSmsRetriever()
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
            tv_status.text = "Waiting for the OTP"

            val otpListener = object : MySMSBroadcastReceiver.OTPReceiveListener {
                override fun onOTPReceived(otp: String) {
//                    customCodeInput.setText(otp)
                    Log.d(TAG, "onOTPReceived: $otp")
                    tv_status.text = otp
                    Toast.makeText(this@SmsRetrieverTest101Activity, otp, Toast.LENGTH_LONG).show()
                }

                override fun onOTPTimeOut() {
                    Log.d(TAG, "onOTPTimeOut: ")
                    tv_status.text = "TimeOut"
                    Toast.makeText(this@SmsRetrieverTest101Activity, "TimeOut", Toast.LENGTH_SHORT).show()
                }
            }

            smsBroadcast.initOTPListener(otpListener)
            registerReceiver(smsBroadcast, IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION))
        })

        task.addOnFailureListener(OnFailureListener {
            // Failed to start retriever, inspect Exception for more details
            // ...
            Log.d(TAG, ": addOnFailureListener()")
            tv_status.text = "Cannot Start SMS Retriever"

        })
    }

    fun generateMessage(view: View) {

        val appSignatureHelper = AppSignatureHelper(applicationContext)
        val appSignatures = appSignatureHelper.appSignatures
        val message = "<#> Your ExampleApp code is:123ABC78 ${appSignatures[0]}"
        Log.d(TAG, message)
        tv_generated_message.text = message
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(smsBroadcast)
    }
}
