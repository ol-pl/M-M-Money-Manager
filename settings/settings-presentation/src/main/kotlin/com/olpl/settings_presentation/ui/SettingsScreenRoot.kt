package com.olpl.settings_presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.olpl.core_presentation.components.BaseScreen
import com.olpl.settings_presentation.ui.ui_event_handlers.SettingsScreenUiEventHandler

@Composable
fun SettingsScreenRoot() {
    SettingsScreenUiEventHandler()

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