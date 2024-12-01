package com.olpl.core_ui.providers.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal

@Composable
fun <T> ProvidableCompositionLocal<T?>.currentNotNull(): T = checkNotNull(current)