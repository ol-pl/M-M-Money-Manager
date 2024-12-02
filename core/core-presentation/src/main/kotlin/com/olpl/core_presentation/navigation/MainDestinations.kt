package com.olpl.core_presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class MainDestinations : Destination {

    @Serializable
    data object Settings : MainDestinations()
}