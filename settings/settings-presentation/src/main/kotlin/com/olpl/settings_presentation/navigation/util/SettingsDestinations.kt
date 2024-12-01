package com.olpl.settings_presentation.navigation.util

import kotlinx.serialization.Serializable

@Serializable
sealed class SettingsDestinations {
    @Serializable
    data object SettingsScreen : SettingsDestinations()

    @Serializable
    internal data object ColorsDialog : SettingsDestinations()

    @Serializable
    internal data object ColorModeDialog : SettingsDestinations()

    @Serializable
    internal data object FontVariantDialog : SettingsDestinations()
}