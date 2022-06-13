package com.example.composesettings.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.composesettings.SettingItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HintSettingsItems(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
    onCheckChanged: () -> Unit
) {
    SettingItem(modifier = modifier) {
        val notificationStateDescription = if(checked) {
            stringResource(id = R.string.cd_hints_enabled)
        } else{
            stringResource(id = R.string.cd_hints_disabled)
        }

        Row (
            modifier = Modifier
                .toggleable(
                    value = checked,
                    onValueChange = { onCheckChanged() },
                    role = Role.Checkbox
                )
                .semantics {
                    stateDescription = notificationStateDescription
                }
                .padding(
                    horizontal = 16.dp,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(weight = 1f),
                text = title
            )
            Checkbox(
                checked = checked,
                onCheckedChange = null
            )
        }
    }
}

@Preview
@Composable
fun HintSettingsPreview() {
    HintSettingsItems(title = "Show Hints", checked = true, onCheckChanged = {})
}