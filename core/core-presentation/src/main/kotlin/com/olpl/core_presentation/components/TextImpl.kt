package com.olpl.core_presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.olpl.utils.StringId

@Composable
fun TextImpl(
    text: StringId,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    textAlign: TextAlign = TextAlign.Center,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1
) {
    TextImpl(
        text = stringResource(text),
        style = style,
        modifier = modifier,
        overflow = overflow,
        minLines = minLines,
        maxLines = maxLines,
        textColor = textColor,
        textAlign = textAlign
    )
}

@Composable
fun TextImpl(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    textAlign: TextAlign = TextAlign.Center,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        overflow = overflow,
        minLines = minLines,
        maxLines = maxLines,
        color = textColor,
        textAlign = textAlign
    )
}