package com.example.composesettings.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesettings.R
import com.example.composesettings.SettingItem

@Composable
fun AppVersionSettingItem(
    modifier: Modifier = Modifier,
    appVersion: String
) {
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .semantics(mergeDescendants = true) {},
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.title_app_version_setting)
            )

            Text(text = appVersion)
        }
    }
}

@Preview
@Composable
fun PreviewAppVersionSettingItem() {
    AppVersionSettingItem(
        appVersion = "1.0.0"
    )
}