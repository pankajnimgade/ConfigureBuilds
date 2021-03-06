package configure.test.configurebuilds.activities.test101

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

private val TAG = "SMSBroadcastReceiver"

/**
 * Created by Pankaj Nimgade on 3/20/2019.
 */
class MySMSBroadcastReceiver : BroadcastReceiver() {

    private var otpReceiver: OTPReceiveListener? = null

    fun initOTPListener(receiver: OTPReceiveListener) {
        Log.d(TAG, "initOTPListener(): ")
        this.otpReceiver = receiver
    }

    @SuppressLint("LogNotTimber")
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "onReceive: ${intent.action}")
        if (SmsRetriever.SMS_RETRIEVED_ACTION == intent.action) {
            val extras = intent.extras
            val status = extras?.get(SmsRetriever.EXTRA_STATUS) as Status

            when (status.statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    // Get SMS message contents
                    Log.d(TAG, "onReceive: CommonStatusCodes.SUCCESS")
                    Toast.makeText(context, "CommonStatusCodes.SUCCESS", Toast.LENGTH_LONG).show()
                    var otp: String = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE) as String
                    Log.d(TAG, ": $otp")

                    // Extract one-time code from the message and complete verification
                    // by sending the code back to your server for SMS authenticity.
                    // But here we are just passing it to MainActivity
                    if (otpReceiver != null) {
//                        otp = otp.replace("<#> Your ExampleApp code is: ", "").split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]
                        otpReceiver?.onOTPReceived(otp)
                    }
                }

                CommonStatusCodes.TIMEOUT -> {
                    // Waiting for SMS timed out (5 minutes)
                    // Handle the error ...
                    Toast.makeText(context, "CommonStatusCodes.TIMEOUT", Toast.LENGTH_LONG).show()
                    Log.d(TAG, "onReceive: CommonStatusCodes.TIMEOUT")
                    otpReceiver?.onOTPTimeOut()
                }

            }
        }
    }

    companion object {

        private lateinit var otpReceiveListener: OTPReceiveListener

        fun bindListener(otpReceiveListener: OTPReceiveListener) {
            this.otpReceiveListener = otpReceiveListener
        }
    }

    interface OTPReceiveListener {

        fun onOTPReceived(otp: String)

        fun onOTPTimeOut()
    }
}