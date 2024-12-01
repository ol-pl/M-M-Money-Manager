package com.olpl.settings_presentation.viewmodel.events

import com.olpl.core_ui.theme.util.ColorMode
import com.olpl.core_ui.theme.util.FontFamilyVariants
import com.olpl.core_ui.theme.util.PaletteVariants
import com.olpl.core_ui.viewmodel.events.Events

sealed interface SettingsEvents : Events {
    data class SetColorPalette(val paletteVariant: PaletteVariants) : SettingsEvents
    data class SetColorMode(val colorMode: ColorMode) : SettingsEvents
    data class SetFont(val fontFamilyVariants: FontFamilyVariants) : SettingsEvents
}