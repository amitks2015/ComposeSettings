package com.example.composesettings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composesettings.settings.NotificationSettings
import com.example.composesettings.settings.SettingsState
import com.example.composesettings.ui.theme.ComposeSettingsTheme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Settings()
        }
    }
}

@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()

    ComposeSettingsTheme {
        val state = viewModel.uiState.collectAsState().value
        SettingsList(
            state = state,
            viewModel = viewModel
        )
    }
}

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    state: SettingsState,
    viewModel: SettingsViewModel
) {
    Column(
        modifier = modifier.verticalScroll(
            rememberScrollState()
        )
    ) {
        TopAppBar()
        NotificationSettings(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.title_notification_settings),
            checked = state.notificationsEnabled,
            onToggleNotificationSetting = viewModel::toggleNotificationEnabled
        )
        Divider()
    }
}

@Composable
private fun TopAppBar() {
    SmallTopAppBar(
        title = {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = stringResource(id = R.string.title_settings),
                fontSize = 18.sp
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.cd_navigate_back)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSettingsTheme {
        Settings()
    }
}