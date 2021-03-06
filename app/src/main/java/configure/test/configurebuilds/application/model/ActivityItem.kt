package configure.test.configurebuilds.application.model

import android.app.Activity
import configure.test.configurebuilds.activities.ExampleActivity
import configure.test.configurebuilds.activities.accessibility.AccessibilityActivity
import configure.test.configurebuilds.activities.custom101.view.CustomViewActivity
import configure.test.configurebuilds.activities.custom102.tablayout.CustomTabLayoutActivity
import configure.test.configurebuilds.activities.decorator_one.DecoratorOneActivity
import configure.test.configurebuilds.activities.decorator_two.DecoratorTwoActivity
import configure.test.configurebuilds.activities.dock.list.ListActivity
import configure.test.configurebuilds.activities.dock.list.TestDockTileActivity
import configure.test.configurebuilds.activities.edittext.CustomEditTextActivity
import configure.test.configurebuilds.activities.expresso.ExpressoTestActivity
import configure.test.configurebuilds.activities.superscript.SuperScriptActivity

/**
 * Created by Pankaj Nimgade on 3/11/2018.
 */
open class ActivityItem(val activityClass: Class<out Activity>, val activityName: String) {


    companion object {

        val list: MutableList<ActivityItem> = mutableListOf<ActivityItem>()

        @JvmStatic
        fun getActivityItemList(): List<ActivityItem> {
            if (list.isEmpty()) {
                list.add(ActivityItem(AccessibilityActivity::class.java, "Accessibility Test"))
                list.add(ActivityItem(SuperScriptActivity::class.java, "Super Script test"))
                list.add(ActivityItem(CustomTabLayoutActivity::class.java, "Custom Tab Layout"))
                list.add(ActivityItem(ExpressoTestActivity::class.java, "Expresso Test Activity"))
                list.add(ActivityItem(CustomViewActivity::class.java, "Custom View Activity"))
                list.add(ActivityItem(CustomEditTextActivity::class.java, "Custom EditText Activity"))
                list.add(ActivityItem(ExampleActivity::class.java, "Example Activity"))
                list.add(ActivityItem(ListActivity::class.java, "List Item"))
                list.add(ActivityItem(TestDockTileActivity::class.java, "Test Dock tile"))
                list.add(ActivityItem(DecoratorOneActivity::class.java, "Decorator One"))
                list.add(ActivityItem(DecoratorTwoActivity::class.java, "Decorator Two"))
            }

            return list
        }

    }
}