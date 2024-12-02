package com.olpl.core_presentation.providers

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

val LocalMainNavigator = staticCompositionLocalOf<NavHostController?> { null }

val LocalCurrentNavigator = staticCompositionLocalOf<NavHostController?> { null }
