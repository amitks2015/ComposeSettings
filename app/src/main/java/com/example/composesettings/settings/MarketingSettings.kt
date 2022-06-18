package com.example.composesettings.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesettings.R
import com.example.composesettings.SettingItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketingSettings(
    modifier: Modifier = Modifier,
    title:String,
    selectedOption: MarketingOption,
    onOptionSelected: (MarketingOption) -> Unit
) {
    val options = stringArrayResource(id = R.array.marketing_options)
    SettingItem(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title)
            Spacer(modifier = Modifier.height(8.dp))
            options.forEachIndexed { index, option ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = selectedOption.id == index,
                            role = Role.RadioButton,
                            onClick = {
                                val marketingOption = if(index == MarketingOption.ALLOWED.id) {
                                    MarketingOption.ALLOWED
                                } else {
                                    MarketingOption.NOT_ALLOWED
                                }
                                onOptionSelected(marketingOption)
                            }
                        )
                        .fillMaxWidth()
                        .padding(all = 8.dp)
                    ,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedOption.id == index,
                        onClick = null
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = option
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMarketingSettings() {
    MarketingSettings(
        title = stringResource(id = R.string.title_marketing_settings),
        selectedOption = MarketingOption.ALLOWED,
        onOptionSelected = {}
    )
}