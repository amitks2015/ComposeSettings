package com.example.composesettings

import androidx.lifecycle.ViewModel
import com.example.composesettings.settings.MarketingOption
import com.example.composesettings.settings.SettingsState
import com.example.composesettings.settings.Theme
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel: ViewModel() {

    val uiState = MutableStateFlow(SettingsState())

    fun toggleNotificationEnabled() {
        uiState.value = uiState.value.copy(notificationsEnabled = !uiState.value.notificationsEnabled)
    }

    fun toggleHintEnabled() {
        uiState.value = uiState.value.copy(hintsEnabled = !uiState.value.hintsEnabled)
    }

    fun setMarketingSetting(option: MarketingOption) {
        uiState.value = uiState.value.copy(marketingOption = option)
    }

    fun setTheme(option: Theme) {
        uiState.value = uiState.value.copy(themeOption = option)
    }
}