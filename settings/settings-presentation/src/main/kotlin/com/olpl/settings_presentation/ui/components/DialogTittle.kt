package com.olpl.settings_presentation.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import com.olpl.core_presentation.components.TextImpl
import com.olpl.utils.StringId

@Composable
internal fun DialogTittle(
    text: StringId
) {
    TextImpl(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        textColor = colorScheme.primary
    )
}