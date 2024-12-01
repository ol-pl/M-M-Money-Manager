package com.olpl.core_ui.components

import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.olpl.core_ui.providers.LocalElevations
import com.radusalagean.infobarcompose.InfoBar
import com.radusalagean.infobarcompose.InfoBarMessage

@Composable
fun InfoBarImpl(
    infoBarMessage: State<InfoBarMessage?>,
    onDismiss: () -> Unit
) {
    val elevation = LocalElevations.current
    val configuration = LocalConfiguration.current
    val minWidth = (configuration.screenWidthDp * 0.35f).dp
    val maxWidth = (configuration.screenWidthDp * 0.75f).dp

    InfoBar(
        modifier = Modifier.widthIn(min = minWidth, max = maxWidth),
        offeredMessage = infoBarMessage.value,
        elevation = elevation.medium,
        textColor = colorScheme.onPrimary,
        backgroundColor = colorScheme.secondary,
        actionColor = colorScheme.primary,
        textStyle = typography.bodyLarge,
        shape = shapes.medium,
        onDismiss = onDismiss
    )
}