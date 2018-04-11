package configure.test.configurebuilds.application.model

import android.app.Activity
import configure.test.configurebuilds.activities.ExampleActivity
import configure.test.configurebuilds.activities.dock.list.ListActivity
import configure.test.configurebuilds.activities.edittext.CustomEditTextActivity

/**
 * Created by Pankaj Nimgade on 3/11/2018.
 */
class ActivityItem(val activityClass: Class<out Activity>, val activityName: String) {


    companion object {
        fun getActivityItemList(): List<ActivityItem> {
            val list = mutableListOf<ActivityItem>()
            list.add(ActivityItem(CustomEditTextActivity::class.java, "Custom EditText Activity"))
            list.add(ActivityItem(ExampleActivity::class.java, "Example Activity"))
            list.add(ActivityItem(ListActivity::class.java, "List Item"))
            return list
        }
    }
}