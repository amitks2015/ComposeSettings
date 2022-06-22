package com.example.composesettings.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.composesettings.Tags.TAG_SELECT_THEME
import com.example.composesettings.Tags.TAG_THEME
import com.example.composesettings.Tags.TAG_THEME_OPTION
import org.junit.Rule
import org.junit.Test

class ThemeSettingsTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun test_selected_theme_displayed() {
        val option = Theme.SYSTEM

        composeRule.setContent {
            ThemeSettingItem(
                title = "Theme Settings",
                selectedTheme = option,
                onThemeSelected = {})
        }
        composeRule.onNodeWithTag(TAG_THEME, useUnmergedTree = true)
            .assertTextEquals(
                InstrumentationRegistry.getInstrumentation()
                    .targetContext.getString(option.label)
            )
    }

    @Test
    fun test_theme_option_displayed() {

        composeRule.setContent {
            ThemeSettingItem(
                title = "Theme",
                selectedTheme = Theme.DARK,
                onThemeSelected = {}
            )
        }

        composeRule.onNodeWithTag(TAG_SELECT_THEME).performClick()

        Theme.values().forEachIndexed { _, theme ->
            composeRule
                .onNodeWithTag(
                    TAG_THEME_OPTION + InstrumentationRegistry
                    .getInstrumentation()
                    .targetContext
                    .getString(theme.label)
                    )
                .assertIsDisplayed()
        }
    }
}