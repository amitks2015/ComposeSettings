package com.example.composesettings.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.composesettings.R
import com.example.composesettings.SettingItem
import com.example.composesettings.Tags.TAG_SELECT_THEME
import com.example.composesettings.Tags.TAG_THEME
import com.example.composesettings.Tags.TAG_THEME_OPTION

@Composable
fun ThemeSettingItem(
    modifier: Modifier = Modifier,
    title: String,
    selectedTheme: Theme,
    onThemeSelected: (Theme) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier
                .clickable(
                    onClickLabel = stringResource(id = R.string.select_theme)
                ) {
                    expanded = !expanded
                }
                .padding(horizontal = 16.dp)
                .testTag(TAG_SELECT_THEME),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = title,
            )
            Text(
                modifier = Modifier.testTag(TAG_THEME),
                text = stringResource(id = selectedTheme.label)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(x = 16.dp, y = 0.dp)
        ) {
            Theme.values().forEach {
                DropdownMenuItem(
                    modifier = Modifier.testTag(TAG_THEME_OPTION + stringResource(id = it.label)),
                    text = {
                        Text(text = stringResource(id = it.label))
                    },
                    onClick = {
                        onThemeSelected(it)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewThemeSettingItem() {
    ThemeSettingItem(
        title = "Theme",
        selectedTheme = Theme.DARK,
        onThemeSelected = {})
}