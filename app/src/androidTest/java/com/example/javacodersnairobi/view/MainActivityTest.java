package com.example.javacodersnairobi.view;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.javacodersnairobi.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityLayoutIsDisplayed() {
        onView(withId(R.id.home_screen)).check(matches(isDisplayed()));
    }

    @Test
    public void recyclerViewIsDisplayed() {
        onView(withId(R.id.users_list)).check(matches(isDisplayed()));
    }
}
