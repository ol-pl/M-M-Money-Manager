package com.olpl.core_ui.theme.fonts

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import com.olpl.core_ui.R

private val RobotoFont = Font(
    resId = R.font.roboto,
    loadingStrategy = FontLoadingStrategy.Blocking
)

internal val RobotoFontFamily = FontFamily(RobotoFont)