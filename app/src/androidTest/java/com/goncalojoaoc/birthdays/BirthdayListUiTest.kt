package com.goncalojoaoc.birthdays

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.MediumTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.goncalojoaoc.birthdays.helpers.ApiMockResponseReader
import com.goncalojoaoc.birthdays.helpers.UiTest
import com.goncalojoaoc.birthdays.ui.BirthdaysActivity
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4ClassRunner::class)
class BirthdayListUiTest : UiTest() {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(BirthdaysActivity::class.java)

    @Test
    fun birthdaysAreDisplayed() {
        // todo remove this into a helper class
        val content = ApiMockResponseReader(R.raw.birthdays).getContent()
        webServer?.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse().setResponseCode(200).setBody(content)
            }
        }

        onView(withText("Pamela Howell")).check(matches(isDisplayed()))
        onView(withText("PH")).check(matches(isDisplayed()))
        onView(withText("1980-02-26")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenDetailView() {
        // todo
    }
}