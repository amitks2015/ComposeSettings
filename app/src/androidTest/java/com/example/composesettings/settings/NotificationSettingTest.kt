package com.example.composesettings.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class NotificationSettingTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun title_displayed() {
        val title = "Enable Notification"
        composeTestRule.setContent {
            NotificationSettings(
                title = title,
                checked = true) {}
        }
        composeTestRule.onNodeWithText(text = title)
            .assertIsDisplayed()
    }

    @Test
    fun settings_checked() {
        val title = "Enable Notification"
        composeTestRule.setContent {
            NotificationSettings(
                title = title,
                checked = true) {}
        }
        composeTestRule.onNodeWithText(text = title)
            .assertIsOn()
    }
}