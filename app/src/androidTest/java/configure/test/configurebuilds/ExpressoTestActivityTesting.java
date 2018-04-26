package configure.test.configurebuilds;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import configure.test.configurebuilds.activities.expresso.ExpressoTestActivity;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExpressoTestActivityTesting {


    @Rule
    public ActivityTestRule<ExpressoTestActivity> mActivityRule =
            new ActivityTestRule(ExpressoTestActivity.class);


    @Test
    public void clickOnButton() {
        Espresso.onView(ViewMatchers.withId(R.id.ExpressoTestActivity_click_button)).perform
                (ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.ExpressoTestActivity_text_textView))
                .check(ViewAssertions.matches(ViewMatchers.withText("Clicked")));
    }
}
