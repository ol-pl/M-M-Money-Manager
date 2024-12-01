package com.olpl.settings_presentation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.olpl.core_ui.providers.LocalElevations

@Composable
fun DialogScreen(
    modifier: Modifier,
    onBackAction: () -> Unit,
    content: @Composable () -> Unit
) {
    val elevation = LocalElevations.current

    BackHandler(onBack = onBackAction)
    Surface(
        color = MaterialTheme.colorScheme.secondary,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        shadowElevation = elevation.medium,
        tonalElevation = elevation.medium,
        content = content
    )
}