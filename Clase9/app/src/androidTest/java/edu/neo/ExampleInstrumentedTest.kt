package edu.neo

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {


    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun testButton(){
        // enlazamos el id como un objeto --->
        Espresso.onView(ViewMatchers.withId(R.id.user)).perform(ViewActions.typeText("dante"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.password)).perform(ViewActions.typeText("123"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.login)).perform(ViewActions.click())
    }


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("edu.neo", appContext.packageName)
    }
}