package com.example.javacodersnairobi.view;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import com.example.javacodersnairobi.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DetailActivityTest {
    @Rule
    public IntentsTestRule<DetailActivity> intentRule = new IntentsTestRule<>(DetailActivity.class,
            true, false);

    @Before
    public void startActivity() throws InterruptedException {
        Intent intent = new Intent();
        intent.putExtra(MainActivity.EXTRA_USERNAME, "jumaallan");
        intentRule.launchActivity(intent);
        Thread.sleep(4000);
    }

    @Test
    public void profileImageIsDisplayed() {
        onView(withId(R.id.profile_image)).check(matches(isDisplayed()));
    }

    @Test
    public void shareButtonIsDisplayed() {
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void usesDetailActivityLayoutFile() {
        onView(withId(R.id.detail_layout)).check(matches(isDisplayed()));
    }
}
