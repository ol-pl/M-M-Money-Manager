package com.olpl.core_ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import com.olpl.core_ui.providers.LocalPaddings
import com.olpl.utils.StringId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarImpl(
    title: StringId,
    navigationIcon: @Composable (() -> Unit) = {},
    actions: @Composable (RowScope.() -> Unit) = {},
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary
    ),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    val density = LocalDensity.current
    val paddings = LocalPaddings.current
    val leftAndRightInsets = with(density) {
        paddings.medium.roundToPx()
    }
    val topInsets = WindowInsets.statusBars.getTop(density)
    CenterAlignedTopAppBar(
        colors = colors,
        windowInsets = WindowInsets(
            left = leftAndRightInsets,
            top = topInsets,
            right = leftAndRightInsets
        ),
        title = {
            TextImpl(
                text = title,
                style = MaterialTheme.typography.headlineLarge
            )
        },
        navigationIcon = navigationIcon,
        actions = actions,
        scrollBehavior = scrollBehavior
    )
}