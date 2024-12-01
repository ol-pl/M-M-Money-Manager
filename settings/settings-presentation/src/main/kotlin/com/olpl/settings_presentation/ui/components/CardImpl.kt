package com.olpl.settings_presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.olpl.core_ui.components.CardImpl
import com.olpl.core_ui.components.TextImpl
import com.olpl.core_ui.providers.LocalPaddings
import com.olpl.utils.StringId

@Composable
internal fun SettingsCardImpl(
    title: StringId,
    enabled: Boolean = true,
    onClick: () -> Unit,
    showIcon: Boolean = true,
    rightText: @Composable RowScope.() -> Unit
) {
    val paddings = LocalPaddings.current
    val configuration = LocalConfiguration.current
    val minCardHeight = (configuration.screenHeightDp * 0.075f).dp
    CardImpl(
        enabled = enabled,
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = minCardHeight)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextImpl(
                text = title,
                textAlign = TextAlign.Start,
                modifier = Modifier.weight(1f)
            )
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                rightText()
                if(showIcon) {
                    Spacer(modifier = Modifier.padding(paddings.extraSmall))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "settings show more icon",
                        tint = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
        }
    }
}