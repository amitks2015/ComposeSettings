package com.example.composesettings

import androidx.annotation.StringRes
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.example.composesettings.Tags.TAG_TOGGLE_ITEM
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SettingsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            Settings()
        }
    }

    @Test
    fun test_notifications_setting_is_displayed() {
        assertSettingIsDisplayed(R.string.title_notification_settings)
    }

    @Test
    fun test_hints_setting_is_displayed() {
        assertSettingIsDisplayed(R.string.title_hint_settings)
    }

    @Test
    fun test_manage_subscription_setting_is_displayed() {
        assertSettingIsDisplayed(R.string.title_manage_subscription)
    }

    @Test
    fun test_marketing_setting_is_displayed() {
        assertSettingIsDisplayed(R.string.title_marketing_settings)
    }

    @Test
    fun test_theme_setting_is_displayed() {
        assertSettingIsDisplayed(R.string.title_theme_settings)
    }

    @Test
    fun test_app_version_setting_is_displayed() {
        assertSettingIsDisplayed(R.string.title_app_version_setting)
    }

    @Test
    fun test_notification_setting_enable_state() {
        composeTestRule.onNodeWithText(
            text = InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.title_notification_settings)
        ).performClick()

        //This is another way of finding the nodes from a tag
        composeTestRule.onNodeWithTag(
            testTag = TAG_TOGGLE_ITEM
        ).assertIsOn()
    }

    @Test
    fun test_hint_setting_enable_state() {
        composeTestRule.onNodeWithText(
            text = InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.title_hint_settings)
        ).performClick().assertIsOn()
    }

    @Test
    fun test_marketing_setting_allowed_selection() {
        composeTestRule.onNodeWithText(
            text = InstrumentationRegistry.getInstrumentation()
                .targetContext.resources.getStringArray(R.array.marketing_options)[0]
        ).performClick().assertIsSelected()

        composeTestRule.onNodeWithText(
            text = InstrumentationRegistry.getInstrumentation()
                .targetContext.resources.getStringArray(R.array.marketing_options)[1]
        ).assertIsNotSelected()
    }

    @Test
    fun test_marketing_not_allowed_selected() {
        composeTestRule.onNodeWithText(
            text = InstrumentationRegistry.getInstrumentation()
                .targetContext.resources.getStringArray(R.array.marketing_options)[1]
        ).performClick().assertIsSelected()
        composeTestRule.onNodeWithText(
            text = InstrumentationRegistry.getInstrumentation()
                .targetContext.resources.getStringArray(R.array.marketing_options)[0]
        ).assertIsNotSelected()
    }

    private fun assertSettingIsDisplayed( @StringRes title: Int) {
        composeTestRule.onNodeWithText(
            text = InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(title)
        ).assertIsDisplayed()
    }


}

