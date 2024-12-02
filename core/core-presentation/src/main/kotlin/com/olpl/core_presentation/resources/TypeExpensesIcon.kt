package com.olpl.core_presentation.resources

import com.olpl.core_presentation.R
import com.olpl.utils.IconId

sealed class TypeExpenses(
    val iconId: IconId,
    val title: String
) {
    data object Credits : TypeExpenses(iconId = R.drawable.credits_icon, title = "Credits")
    data object Cars : TypeExpenses(iconId = R.drawable.cars_icon, title = "Cars")
    data object Other : TypeExpenses(iconId = R.drawable.other_icon, title = "Other")
    data object Home : TypeExpenses(iconId = R.drawable.home_icon, title = "Home")
    data object Pets : TypeExpenses(iconId = R.drawable.pets_icon, title = "Pets")
    data object Beauty : TypeExpenses(iconId = R.drawable.beauty_icon, title = "Beauty")
    data object Buses : TypeExpenses(iconId = R.drawable.buses_icon, title = "Buses")
    data object Coffee : TypeExpenses(iconId = R.drawable.coffee_icon, title = "Coffee")
    data object Crypto : TypeExpenses(iconId = R.drawable.crypto_icon, title = "Crypto")
    data object Family : TypeExpenses(iconId = R.drawable.family_icon, title = "Family")
    data object Fitness : TypeExpenses(iconId = R.drawable.fitnes_icon, title = "Fitness")
    data object Games : TypeExpenses(iconId = R.drawable.games_icon, title = "Games")
    data object Gifts : TypeExpenses(iconId = R.drawable.gifts_icon, title = "Gifts")
    data object Grocery : TypeExpenses(iconId = R.drawable.grocery_icon, title = "Grocery")
    data object Health : TypeExpenses(iconId = R.drawable.health_icon, title = "Health")
    data object Internet : TypeExpenses(iconId = R.drawable.internet_icon, title = "Internet")
    data object Movies : TypeExpenses(iconId = R.drawable.movies_icon, title = "Movies")
    data object Payments : TypeExpenses(iconId = R.drawable.payments_icon, title = "Payments")
    data object Repairs : TypeExpenses(iconId = R.drawable.repairs_icon, title = "Repairs")
    data object Saving : TypeExpenses(iconId = R.drawable.saving_icon, title = "Saving")
    data object Shopping : TypeExpenses(iconId = R.drawable.shopping, title = "Shopping")
    data object Taxis : TypeExpenses(iconId = R.drawable.taxis_icon, title = "Taxis")
    data object Trains : TypeExpenses(iconId = R.drawable.trains_icon, title = "Trains")
    data object Travels : TypeExpenses(iconId = R.drawable.travels_icon, title = "Travels")
    data object ShowMore : TypeExpenses(iconId = R.drawable.show_more_icon, title = "More")
    data object Transactions : TypeExpenses(
        iconId = R.drawable.transactions_icon,
        title = "Transactions"
    )

    data object Restaurants : TypeExpenses(
        iconId = R.drawable.restaurants_icon,
        title = "Restaurants"
    )

    /**
     * @return Elements in range from getAll
     * @see getAll
     */
    fun getRange(from: Int, to: Int): List<TypeExpenses> = getAll().subList(from, to)

    /**
     *@return All elements without ShowMore
     */
    fun getAll(): List<TypeExpenses> = listOf(
        Grocery, Taxis, Transactions, Payments, Coffee, Shopping, Other, Movies,
        Restaurants, Credits, Home, Family, Saving, Pets, Beauty, Fitness,
        Games, Gifts, Health, Internet, Travels, Crypto, Cars, Buses, Trains, Repairs,
    )

    fun getAllTitles(): List<String> = getAll().map { it.title }
}