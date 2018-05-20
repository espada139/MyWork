package com.zero.bless;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.zero.bless.mvp.ui.home.HomeTestActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by xiaocai on 2018/5/19.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeTest {
    @Rule
    public ActivityTestRule<HomeTestActivity> activityTestRule = new ActivityTestRule<HomeTestActivity>(HomeTestActivity.class);

    @Test
    public void testTextView(){
        onView(withId(R.id.leftbar_tv)).check(matches(withText("LeftBar")));
    }

    @Test
    public void testSave() throws Exception{
        String name = "Jack";
        onView(allOf(withId(R.id.test_input_et),isDisplayed())).perform(replaceText(name),closeSoftKeyboard());
        onView(allOf(withId(R.id.save_test),isDisplayed())).perform(click());
        Thread.sleep(5000);
        name = "Lucidsdfsdfsdf";
        onView(allOf(withId(R.id.test_input_et),isDisplayed())).perform(typeText(name),closeSoftKeyboard());
        onView(allOf(withId(R.id.save_test),isDisplayed())).perform(click());
        Thread.sleep(2000);
        name = "Stevedsdfdf";
        onView(allOf(withId(R.id.test_input_et),isDisplayed())).perform(replaceText(name),closeSoftKeyboard());
        onView(allOf(withId(R.id.save_test),isDisplayed())).perform(click());
        Thread.sleep(2000);
        name = "Sanosss";
        onView(allOf(withId(R.id.test_input_et),isDisplayed())).perform(typeTextIntoFocusedView(name),closeSoftKeyboard());
        Thread.sleep(2000);
        onView(allOf(withId(R.id.save_test),isDisplayed())).perform(click());
        Thread.sleep(2000);
    }
}
