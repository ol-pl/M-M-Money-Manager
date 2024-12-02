package com.olpl.core_presentation.navigation

import androidx.navigation.NavHostController

abstract class NavigatorDef(val navHostController: NavHostController) {
    protected inline fun <reified T : Destination> navigateTo(
        route: T,
        popUpToRoute: T? = null,
        inclusiveEnabled: Boolean = true,
        saveStateEnabled: Boolean = true,
        restoreStateEnabled: Boolean = true
    ) {
        navHostController.navigate(route) {
            popUpToRoute?.let {
                popUpTo(popUpToRoute) {
                    inclusive = inclusiveEnabled
                    saveState = saveStateEnabled
                }
                restoreState = restoreStateEnabled
            }
        }
    }

    fun navigateUp() {
        navHostController.navigateUp()
    }
}