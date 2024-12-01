package com.olpl.core_ui.theme.fonts

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import com.olpl.core_ui.R

private val OswaldFont = Font(
    resId = R.font.dancing_script,
    loadingStrategy = FontLoadingStrategy.Async
)

internal val OswaldFontFamily = FontFamily(OswaldFont)
