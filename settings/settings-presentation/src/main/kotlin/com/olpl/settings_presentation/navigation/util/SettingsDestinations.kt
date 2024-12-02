package com.olpl.settings_presentation.navigation.util

import com.olpl.core_presentation.navigation.Destination
import kotlinx.serialization.Serializable

@Serializable
sealed class SettingsDestinations : Destination {
    @Serializable
    data object SettingsScreen : SettingsDestinations()

    @Serializable
    internal data object ColorsDialog : SettingsDestinations()

    @Serializable
    internal data object ColorModeDialog : SettingsDestinations()

    @Serializable
    internal data object FontVariantDialog : SettingsDestinations()
}