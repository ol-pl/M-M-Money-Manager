package com.olpl.settings_presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.olpl.core_ui.components.BaseScreen

@Composable
fun SettingsScreenRoot() {
    BaseScreen(
        infoBarMessage = remember {
            mutableStateOf(null)
        },
        onInfoBarDismiss = {},
        onBackAction = {},
        topBar = {
            SettingsTopAppBar()
        }
    ) { paddings ->
        SettingsScreen(paddings)
    }
}