package com.example.composesettings.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesettings.R
import com.example.composesettings.ui.theme.ComposeSettingsTheme

@Composable
fun NotificationSettings(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
    onToggleNotificationSetting: () -> Unit
) {
    Surface(
        modifier = modifier
    ) {
        val notificationStateDescription = if(checked) {
            stringResource(id = R.string.cd_notification_enabled)
        } else{
            stringResource(id = R.string.cd_notification_disabled)
        }

        Row (
            modifier = Modifier
                .toggleable(
                    value = checked,
                    onValueChange = {
                        onToggleNotificationSetting()
                    },
                    role = Role.Switch
                )
                .semantics {
                    stateDescription = notificationStateDescription
                }
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(weight = 1f),
                text = title
            )
            Switch(
                checked = checked,
                onCheckedChange = null
            )
        }
    }
}

@Preview
@Composable
fun NotificationSettingsPreview() {
    ComposeSettingsTheme {
        NotificationSettings(
            title = "Notification Settings",
            checked = true,
            onToggleNotificationSetting = {}
        )
    }
}