package com.olpl.settings_presentation.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.olpl.core_presentation.providers.LocalElevations
import com.olpl.core_presentation.providers.LocalPaddings

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun DialogScreen(
    modifier: Modifier,
    onBackAction: () -> Unit,
    confirmButton: @Composable () -> Unit,
    dismissButton: @Composable () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    val elevation = LocalElevations.current
    val paddings = LocalPaddings.current

    BackHandler(onBack = onBackAction)
    Surface(
        color = MaterialTheme.colorScheme.secondary,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        shadowElevation = elevation.medium,
        tonalElevation = elevation.medium,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddings.medium),
                verticalArrangement = Arrangement.spacedBy(paddings.extraSmall),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                content()
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    dismissButton()
                    confirmButton()
                }
            }
        }
    )
}