package configure.test.configurebuilds;

import android.app.Application;

import java.util.List;

import configure.test.configurebuilds.activities.CameraListActivity;
import configure.test.configurebuilds.application.model.ActivityItem;
import timber.log.Timber;

public class StartUp extends Application {

    private static final String TAG = "START_UP";

    @Override
    public void onCreate() {
        super.onCreate();
        List<ActivityItem> activityItemList = ActivityItem.getActivityItemList();
        activityItemList.add(0, new ActivityItem(CameraListActivity.class,
                "Camera List"));
        Timber.plant(new Timber.DebugTree());
        Timber.tag("StartUp");
        Timber.i("start up on create");
    }
}
