package configure.test.configurebuilds.application.model

import android.app.Activity
import configure.test.configurebuilds.activities.ExampleActivity

/**
 * Created by Pankaj Nimgade on 3/11/2018.
 */
class ActivityItem(val activityClass: Class<out Activity>, val activityName: String) {


    companion object {
        fun getActivityItemList(): List<ActivityItem> {
            val list = mutableListOf<ActivityItem>()
            list.add(ActivityItem(ExampleActivity::class.java, "Example Activity"))
            return list
        }
    }
}