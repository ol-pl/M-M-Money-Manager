package com.olpl.settings_presentation.navigation.util

import androidx.navigation.NavHostController
import com.olpl.core_presentation.navigation.NavigatorDef

internal class SettingsNavigator(
    currentNavHostController: NavHostController
) : NavigatorDef(currentNavHostController) {

    fun navigateToColorModeDialog() {
        navigateTo(SettingsDestinations.ColorModeDialog)
    }

}