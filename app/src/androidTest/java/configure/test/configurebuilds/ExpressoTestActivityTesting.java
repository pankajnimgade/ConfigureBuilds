package configure.test.configurebuilds;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.Is.is;

import configure.test.configurebuilds.activities.expresso.ExpressoTestActivity;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExpressoTestActivityTesting {


    @Rule
    public ActivityTestRule<ExpressoTestActivity> mActivityRule =
            new ActivityTestRule(ExpressoTestActivity.class);


    @Test
    public void clickOnButton() {
        Espresso.onView(withId(R.id.ExpressoTestActivity_click_button)).perform
                (ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.ExpressoTestActivity_text_textView))
                .check(ViewAssertions.matches(ViewMatchers.withText("Clicked")));
    }

    @Test
    public void testToolbarTest(){
        CharSequence title = "ExpressoTestActivity";


        Espresso.onView(isAssignableFrom(Toolbar.class)).check(ViewAssertions
                .matches(withToolbarTitle((Matcher<CharSequence>) title)));

        onView(isAssignableFrom(Toolbar.class))
                .check(matches(withToolbarTitle(is(title))));
    }

    private static Matcher<Object> withToolbarTitle(final Matcher<CharSequence> textMatcher) {
        return new BoundedMatcher<Object, Toolbar>(Toolbar.class) {
            @Override public boolean matchesSafely(Toolbar toolbar) {
                return textMatcher.matches(toolbar.getTitle());
            }
            @Override public void describeTo(Description description) {
                description.appendText("with toolbar title: ");
                textMatcher.describeTo(description);
            }
        };
    }
}
