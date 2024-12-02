package com.olpl.core_presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.olpl.core_presentation.providers.LocalElevations
import com.olpl.core_presentation.providers.LocalPaddings

@Composable
fun ElevatedButtonImpl(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    borderStroke: BorderStroke = BorderStroke(1.dp, colorScheme.primary),
    colors: ButtonColors = ButtonDefaults.elevatedButtonColors(
        containerColor = colorScheme.secondary,
        disabledContainerColor = colorScheme.onSecondary
    ),
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    val elevation = LocalElevations.current
    val paddings = LocalPaddings.current

    ElevatedButton(
        onClick = onClick,
        enabled = enabled,
        contentPadding = PaddingValues(vertical = paddings.extraSmall, horizontal = paddings.small),
        border = borderStroke,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = elevation.small,
            pressedElevation = elevation.medium,
            focusedElevation = elevation.small,
            hoveredElevation = elevation.medium,
            disabledElevation = elevation.extraSmall
        ),
        colors = colors,
        content = content
    )
}