package configure.test.configurebuilds.application;

import android.app.Application;
import android.util.Log;

import configure.test.configurebuilds.Constants;

/**
 * Created by Pankaj Nimgade on 3/11/2018.
 */

public class StartUp extends Application {

    private static final String TAG = "START_UP";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: Type: "+ Constants.Companion.getAPP_TYPE());
    }
}
