package configure.test.configurebuilds.application.model

import android.app.Activity
import configure.test.configurebuilds.activities.ExampleActivity
import configure.test.configurebuilds.activities.custom101.view.CustomViewActivity
import configure.test.configurebuilds.activities.custom102.tablayout.CustomTabLayoutActivity
import configure.test.configurebuilds.activities.decorator_one.DecoratorOneActivity
import configure.test.configurebuilds.activities.decorator_two.DecoratorTwoActivity
import configure.test.configurebuilds.activities.dock.list.ListActivity
import configure.test.configurebuilds.activities.dock.list.TestDockTileActivity
import configure.test.configurebuilds.activities.edittext.CustomEditTextActivity

/**
 * Created by Pankaj Nimgade on 3/11/2018.
 */
class ActivityItem(val activityClass: Class<out Activity>, val activityName: String) {


    companion object {
        fun getActivityItemList(): List<ActivityItem> {
            val list = mutableListOf<ActivityItem>()
            list.add(ActivityItem(CustomTabLayoutActivity::class.java, "Custom Tab Layout"))
            list.add(ActivityItem(CustomViewActivity::class.java, "Custom View Activity"))
            list.add(ActivityItem(CustomEditTextActivity::class.java, "Custom EditText Activity"))
            list.add(ActivityItem(ExampleActivity::class.java, "Example Activity"))
            list.add(ActivityItem(ListActivity::class.java, "List Item"))
            list.add(ActivityItem(TestDockTileActivity::class.java, "Test Dock tile"))
            list.add(ActivityItem(DecoratorOneActivity::class.java, "Decorator One"))
            list.add(ActivityItem(DecoratorTwoActivity::class.java, "Decorator Two"))
            return list
        }
    }
}