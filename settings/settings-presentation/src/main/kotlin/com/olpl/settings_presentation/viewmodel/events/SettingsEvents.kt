package com.olpl.settings_presentation.viewmodel.events

import com.olpl.core_presentation.theme.util.ColorMode
import com.olpl.core_presentation.theme.util.FontFamilyVariants
import com.olpl.core_presentation.theme.util.PaletteVariants
import com.olpl.core_presentation.viewmodel.events.Events

sealed interface SettingsEvents : Events {
    data class SetColorPalette(val paletteVariant: PaletteVariants) : SettingsEvents
    data class SetColorMode(val colorMode: ColorMode) : SettingsEvents
    data class SetFont(val fontFamilyVariants: FontFamilyVariants) : SettingsEvents
    data object GoBack : SettingsEvents

    data object OnColorModeCardClick : SettingsEvents
}