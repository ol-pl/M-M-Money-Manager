package com.olpl.core_presentation.theme.fonts

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import com.olpl.core_presentation.R

private val PlayfairDisplayFont = Font(
    resId = R.font.dancing_script,
    loadingStrategy = FontLoadingStrategy.Async
)

internal val PlayfairDisplayFontFamily = FontFamily(PlayfairDisplayFont)
