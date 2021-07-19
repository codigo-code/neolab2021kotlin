package edu.neo

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserInstrumentedTest {


    @get:Rule
    var activityRule: ActivityTestRule<UserActivity> = ActivityTestRule(UserActivity::class.java)


    @Test
    fun changeTitule(){
        Espresso.onView(ViewMatchers.withId(R.id.u_mensaje)).perform(ViewActions.replaceText("Gracias vuelva prontos!"))

    }

}