package com.example.testdrivendevelopment;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.testdrivendevelopment", appContext.getPackageName());
    }

    @Test
    public void user_can_enter_first_name(){
        onView(withId(R.id.firstName)).perform(typeText("Prince"));
    }
    @Test
    public void user_can_enter_last_name(){
        onView(withId(R.id.lastName)).perform(typeText("Essel"));
    }

    @Test
    public void when_user_enters_first_and_last_name_check_to_confirm_that_message_is_correct(){
        onView(withId(R.id.lastName)).perform(typeText("Prince"));
        onView(withId(R.id.lastName)).perform(typeText("Essel"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Welcome, Prince Essel")));
    }
}
