package com.olpl.core_presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.radusalagean.infobarcompose.InfoBarMessage

@Composable
fun BaseScreen(
    infoBarMessage: State<InfoBarMessage?>,
    onInfoBarDismiss: () -> Unit,
    onBackAction: () -> Unit,
    topBar: @Composable (() -> Unit) = {},
    bottomBar: @Composable (() -> Unit) = {},
    floatingActionButton: @Composable (() -> Unit) = {},
    content: @Composable (PaddingValues) -> Unit
) {
    BackHandler(onBack = onBackAction)
    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
        modifier = Modifier.fillMaxSize(),
        contentColor = Color.Unspecified,
        containerColor = MaterialTheme.colorScheme.secondary
    ) {
        content(it)
    }
    InfoBarImpl(infoBarMessage, onInfoBarDismiss)
}