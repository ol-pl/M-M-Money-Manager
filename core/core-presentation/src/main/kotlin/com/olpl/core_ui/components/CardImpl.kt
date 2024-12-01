package com.olpl.core_ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olpl.core_ui.providers.LocalElevations
import com.olpl.core_ui.providers.LocalPaddings

@Composable
fun CardImpl(
    onClick: () -> Unit = {},
    modifier: Modifier,
    enabled: Boolean = false,
    colors: CardColors = CardDefaults.elevatedCardColors(
        containerColor = MaterialTheme.colorScheme.primary,
        disabledContainerColor = MaterialTheme.colorScheme.primary
    ),
    content: @Composable (ColumnScope.() -> Unit)
) {
    val elevation = LocalElevations.current
    val paddings = LocalPaddings.current
    ElevatedCard(
        enabled = enabled,
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = elevation.small,
            pressedElevation = elevation.medium,
            focusedElevation = elevation.small,
            hoveredElevation = elevation.medium,
            draggedElevation = elevation.medium,
            disabledElevation = elevation.extraSmall
        ),
        colors = colors,
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(paddings.medium)) {
                content()
            }
        }
    )
}