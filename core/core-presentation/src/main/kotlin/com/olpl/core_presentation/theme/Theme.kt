package com.olpl.core_presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.olpl.core_presentation.theme.colors.DarkSchemeP1
import com.olpl.core_presentation.theme.colors.DarkSchemeP2
import com.olpl.core_presentation.theme.colors.LightSchemeP1
import com.olpl.core_presentation.theme.colors.LightSchemeP2
import com.olpl.core_presentation.theme.util.ColorMode
import com.olpl.core_presentation.theme.util.FontFamilyVariants
import com.olpl.core_presentation.theme.util.PaletteVariants
import com.olpl.core_presentation.util.getTypography
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MoneyManagerTheme(
    colorModeState: StateFlow<ColorMode>,
    paletteVariantsState: StateFlow<PaletteVariants>,
    fontFamilyVariantsState: StateFlow<FontFamilyVariants>,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val paletteVariant = paletteVariantsState.collectAsStateWithLifecycle()
    val fontFamilyVariant = fontFamilyVariantsState.collectAsStateWithLifecycle()
    val colorMode = colorModeState.collectAsStateWithLifecycle()

    val darkTheme = when (colorMode.value) {
        ColorMode.Auto -> isSystemInDarkTheme()
        ColorMode.Dark -> true
        ColorMode.Light -> false
    }

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(
                context
            )
        }

        paletteVariant.value == PaletteVariants.P2 -> {
            if (darkTheme) DarkSchemeP2 else LightSchemeP2
        }

        paletteVariant.value == PaletteVariants.P1 -> {
            if (darkTheme) DarkSchemeP1 else LightSchemeP1
        }

        else -> LightSchemeP1
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = getTypography(fontFamilyVariant.value),
        content = content
    )
}