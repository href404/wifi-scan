package com.href404.wifiscan

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeFragmentTest {

    @Test
    fun displayWifiInformations() {
        val scenario = launchFragmentInContainer<HomeFragment>()

        onView(withId(R.id.network_counter)).check(matches(isDisplayed()))
        onView(withId(R.id.ssid)).check(matches(isDisplayed()))
        onView(withId(R.id.frequency)).check(matches(isDisplayed()))
        onView(withId(R.id.level)).check(matches(isDisplayed()))

        scenario.close()
    }
}