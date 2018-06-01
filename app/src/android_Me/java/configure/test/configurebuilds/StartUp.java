package configure.test.configurebuilds;

import android.app.Application;

import configure.test.configurebuilds.application.model.ActivityItem;
import configure.test.configurebuilds.ui.AndroidMeActivity;

public class StartUp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ActivityItem.getActivityItemList().add(0, new ActivityItem(AndroidMeActivity
                .class, "Android Me"));
    }
}
