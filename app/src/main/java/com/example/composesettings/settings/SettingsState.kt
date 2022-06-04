package com.example.composesettings.settings

import androidx.annotation.StringRes
import com.example.composesettings.R

data class SettingsState(
    val notificationsEnabled: Boolean = false,
    val hintsEnabled: Boolean = false,
    val marketingOption: MarketingOption = MarketingOption.ALLOWED,
    val themeOption: Theme = Theme.SYSTEM,
)

enum class MarketingOption(val id: Int) {
    ALLOWED(id = 0),
    NOT_ALLOWED(id = 1)
}

enum class Theme(@StringRes val label: Int) {
    LIGHT(R.string.theme_light),
    DARK(R.string.theme_dark),
    SYSTEM(R.string.theme_system)
}