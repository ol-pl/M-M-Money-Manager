package com.olpl.settings_presentation.viewmodel.events

import com.olpl.core_presentation.viewmodel.events.UiEvents

sealed interface SettingsUiEvents: UiEvents {
    data object GoBack : SettingsUiEvents
    data object OpenColorModeDialog : SettingsUiEvents
}