package com.olpl.settings_presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import com.olpl.settings_presentation.navigation.util.SettingsDestinations
import com.olpl.settings_presentation.ui.SettingsScreenRoot

fun NavGraphBuilder.settingsGraph() {
    composable<SettingsDestinations.SettingsScreen> {
        SettingsScreenRoot()
    }
    dialog<SettingsDestinations.ColorsDialog> {}
    dialog<SettingsDestinations.ColorModeDialog> {}
    dialog<SettingsDestinations.FontVariantDialog> {}
}