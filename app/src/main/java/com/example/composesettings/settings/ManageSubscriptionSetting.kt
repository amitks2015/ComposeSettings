package com.example.composesettings.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesettings.R
import com.example.composesettings.SettingItem

@Composable
fun ManageSubscriptionSettingItem(
    modifier: Modifier = Modifier,
    title: String,
    onSettingClicked: () -> Unit
) {
    SettingItem(modifier = modifier) {
        Row(
            modifier = modifier
                .clickable(
                    onClickLabel = stringResource(id = R.string.cd_open_subscription)
                ) { onSettingClicked() }//Order matters, entire row clickable including padding
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = title
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun PreviewManageSubscriptionSettingItem() {
    ManageSubscriptionSettingItem(
        title = "Manage Subscription",
        onSettingClicked = {}
    )
}