package com.olpl.core_ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.olpl.core_ui.theme.colors.DarkSchemeP1
import com.olpl.core_ui.theme.colors.DarkSchemeP2
import com.olpl.core_ui.theme.colors.LightSchemeP1
import com.olpl.core_ui.theme.colors.LightSchemeP2
import com.olpl.core_ui.theme.util.FontFamilyVariants
import com.olpl.core_ui.theme.util.PaletteVariants
import com.olpl.core_ui.util.getTypography

@Composable
fun MoneyManagerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    paletteVariants: PaletteVariants = PaletteVariants.P2,
    fontFamilyVariants: FontFamilyVariants = FontFamilyVariants.Roboto,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        paletteVariants == PaletteVariants.P1 -> if (darkTheme) DarkSchemeP1 else LightSchemeP1
        paletteVariants == PaletteVariants.P2 -> if (darkTheme) DarkSchemeP2 else LightSchemeP2
        else -> LightSchemeP1
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = getTypography(fontFamilyVariants),
        content = content
    )
}