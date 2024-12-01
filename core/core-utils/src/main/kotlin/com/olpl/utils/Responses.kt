package com.olpl.utils

sealed class Responses<T> {
    class Loading<T> : Responses<T>()
    data class Success<T>(val data: T) : Responses<T>()
    data class Error<T>(val message: StringId) : Responses<T>()
}