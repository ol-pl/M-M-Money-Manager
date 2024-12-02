package com.olpl.core_presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import com.olpl.core_presentation.providers.LocalPaddings
import com.olpl.utils.StringId

@Composable
fun RadioButtonImpl(
    text: StringId,
    selected: Boolean,
    enabledWhenSelected: Boolean = false,
    mutableInteractionSource: MutableInteractionSource,
    onClick: () -> Unit
) {
    RadioButtonImpl(
        text = stringResource(text),
        selected = selected,
        enabledWhenSelected = enabledWhenSelected,
        mutableInteractionSource = mutableInteractionSource,
        onClick = onClick
    )
}

@Composable
fun RadioButtonImpl(
    text: String,
    selected: Boolean,
    enabledWhenSelected: Boolean = false,
    mutableInteractionSource: MutableInteractionSource,
    onClick: () -> Unit
) {
    val paddings = LocalPaddings.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = selected.not() || (enabledWhenSelected && selected),
                interactionSource = mutableInteractionSource,
                indication = null,
                onClick = onClick
            ),
        horizontalArrangement = Arrangement.spacedBy(paddings.medium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomRadioButton(
            selected = selected,
            enabledWhenSelected = enabledWhenSelected,
            interactionSource = mutableInteractionSource,
            onClick = onClick
        )
        TextImpl(
            text = text,
            textColor = colorScheme.primary
        )
    }
}

@Composable
private fun CustomRadioButton(
    selected: Boolean,
    enabledWhenSelected: Boolean = false,
    interactionSource: MutableInteractionSource,
    onClick: () -> Unit
) {
    RadioButton(
        interactionSource = interactionSource,
        modifier = Modifier.scale(1.3f),
        selected = selected,
        onClick = onClick,
        enabled = selected.not() || (enabledWhenSelected && selected),
        colors = RadioButtonDefaults.colors(
            selectedColor = colorScheme.primary,
            unselectedColor = colorScheme.primary,
            disabledSelectedColor = colorScheme.primary,
            disabledUnselectedColor = colorScheme.primary
        )
    )
}