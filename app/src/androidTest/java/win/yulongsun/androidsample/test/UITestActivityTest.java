package win.yulongsun.androidsample.test;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import win.yulongsun.androidsample.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @Project AndroidSample
 * @Packate win.yulongsun.androidsample.test
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/4/29
 * @Version 1.0.0
 * @Description
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITestActivityTest {


    ///////////////////////////////////////////////////////////////////////////
    //教程：https://io2015codelabs.appspot.com/codelabs/android-studio-testing#8
    //官方Demo:https://github.com/googlesamples/android-testing
    ///////////////////////////////////////////////////////////////////////////
    private static String STRING_TO_BE_TYPED = "Peter";

    @Rule
    public ActivityTestRule<UITestActivity> mActivityRule = new ActivityTestRule<>(
            UITestActivity.class);

    @Test
    public void sayHello() {
        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard()); //line 1

        onView(withText("Say hello!")).perform(click()); //line 2

        String expectedText = "Hello, " + STRING_TO_BE_TYPED + "!";
        onView(withId(R.id.textView)).check(matches(withText(expectedText))); //line 3
    }

}