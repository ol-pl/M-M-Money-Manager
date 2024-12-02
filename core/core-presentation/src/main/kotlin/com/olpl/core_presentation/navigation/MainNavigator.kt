package com.olpl.core_presentation.navigation

import androidx.navigation.NavHostController

class MainNavigator(
    mainNavHostController: NavHostController
) : NavigatorDef(mainNavHostController) {

    fun <T : Destination> navigateToSettings(currentRoute: T) {
        navigateTo(
            route = MainDestinations.Settings,
            popUpToRoute = currentRoute,
        )
    }

}