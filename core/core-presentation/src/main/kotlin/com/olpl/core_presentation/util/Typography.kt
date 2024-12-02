package com.olpl.core_presentation.util

import androidx.compose.material3.Typography
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.olpl.core_presentation.theme.fonts.DancingScriptFontFamily
import com.olpl.core_presentation.theme.fonts.NotoSansJavaneseFontFamily
import com.olpl.core_presentation.theme.fonts.NotoSerifAhomFontFamily
import com.olpl.core_presentation.theme.fonts.OswaldFontFamily
import com.olpl.core_presentation.theme.fonts.PlayfairDisplayFontFamily
import com.olpl.core_presentation.theme.fonts.PoppinsFontFamily
import com.olpl.core_presentation.theme.fonts.RobotoFontFamily
import com.olpl.core_presentation.theme.fonts.YujiMaiFontFamily
import com.olpl.core_presentation.theme.util.FontFamilyVariants

@Stable
internal fun getTypography(fontFamilyVariants: FontFamilyVariants): Typography {
    val fontFamily = getFontFamily(fontFamilyVariants)
    val defaultTextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.5.sp,
        fontFamily = fontFamily
    )
    return Typography(
        bodyLarge = defaultTextStyle.copy(
            fontSize = 20.sp,
            lineHeight = 28.sp
        ),
        titleLarge = defaultTextStyle.copy(
            fontSize = 28.sp,
            lineHeight = 36.sp
        ),
        headlineLarge = defaultTextStyle.copy(
            fontSize = 36.sp,
            lineHeight = 44.sp
        )
    )
}

private fun getFontFamily(fontFamilyVariants: FontFamilyVariants): FontFamily =
    when (fontFamilyVariants) {
        FontFamilyVariants.DancingScript -> DancingScriptFontFamily
        FontFamilyVariants.NotoSansJavanese -> NotoSansJavaneseFontFamily
        FontFamilyVariants.NotoSerifAhom -> NotoSerifAhomFontFamily
        FontFamilyVariants.Oswald -> OswaldFontFamily
        FontFamilyVariants.PlayfairDisplay -> PlayfairDisplayFontFamily
        FontFamilyVariants.Poppins -> PoppinsFontFamily
        FontFamilyVariants.Roboto -> RobotoFontFamily
        FontFamilyVariants.YujiMain -> YujiMaiFontFamily
    }
