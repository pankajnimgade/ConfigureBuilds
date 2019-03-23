package configure.test.configurebuilds.activities.test101

import java.util.*

/**
 * Created by Pankaj Nimgade on 3/22/2019.
 */
class OtpGenerator {

    companion object {
        fun getCode(): String {

            var otpText = ""
            for (index in 0..5) {
                otpText += (Random()).nextInt(9)
            }
            return otpText
        }
    }
}