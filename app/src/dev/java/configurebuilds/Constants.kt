package configure.test.configurebuilds

/**
 * Created by Pankaj Nimgade on 3/17/2018.
 */
class Constants{

    companion object {
        val APP_TYPE = Type.DEV
    }
}

enum class Type{
    DEV,PROD,FREE,PAID;
}