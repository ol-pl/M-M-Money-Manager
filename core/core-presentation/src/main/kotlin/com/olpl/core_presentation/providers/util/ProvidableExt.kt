package com.olpl.core_presentation.providers.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal

@Composable
fun <T> ProvidableCompositionLocal<T?>.currentNotNull(): T = checkNotNull(current)