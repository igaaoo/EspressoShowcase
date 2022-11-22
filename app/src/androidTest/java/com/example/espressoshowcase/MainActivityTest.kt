package com.example.espressoshowcase

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)

@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)


    @Test //Check if submit button is displayed
    fun isButtonEnabled(){
        onView(withId(R.id.enviar))
            .check(matches(isDisplayed()))
    }

    @Test //Check if edit text hint exists
    fun doEditTextHaveAHint(){
        onView(withId(R.id.telefone))
            .check(matches(withHint("Número de Telefone")))
    }

    @Test //Check if hint is showing after clearing text input
    fun isEditTextHintVisible_afterClearingText(){
        onView(withId(R.id.telefone))
            .perform(typeText("Teste de Hint"))
            .perform(clearText())

        onView(withId(R.id.telefone)).check(matches(withHint("Número de Telefone")))
    }

    @Test //Check if invalid phone warning is showing
    fun isPhoneWarningVisible_whenInvalidPhoneNumberIsSet(){
        onView(withId(R.id.telefone))
            .perform(typeText("859ABCDERFSR"))
        onView(withId(R.id.enviar))
            .perform(click())

        onView(withId(R.id.avisoTele))
            .check(matches(isDisplayed()))
    }


    @Test //Transition between activities checking if number is showing in the second activity
    fun isNumberDisplayedOnSecondActivity(){
        onView(withId(R.id.telefone))
            .perform(typeText("85987654321"))

        onView(withId(R.id.concordo))
            .perform(click())

        onView(withId(R.id.enviar))
            .perform(click())

        onView(withId(R.id.numero))
            .check(matches(withText("85987654321")))
    }






















}