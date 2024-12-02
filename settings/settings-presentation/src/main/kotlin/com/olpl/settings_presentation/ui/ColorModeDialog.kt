package com.olpl.settings_presentation.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.olpl.core_presentation.components.ElevatedButtonImpl
import com.olpl.core_presentation.components.RadioButtonImpl
import com.olpl.core_presentation.components.TextImpl
import com.olpl.core_presentation.providers.LocalPaddings
import com.olpl.core_presentation.theme.util.ColorMode
import com.olpl.core_presentation.util.Qualifiers
import com.olpl.core_presentation.util.SharedStrings
import com.olpl.settings_presentation.R
import com.olpl.settings_presentation.ui.components.DialogScreen
import com.olpl.settings_presentation.ui.components.DialogTittle
import com.olpl.settings_presentation.viewmodel.SettingsViewModel
import com.olpl.settings_presentation.viewmodel.events.SettingsEvents
import kotlinx.coroutines.flow.StateFlow
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

@Composable
internal fun ColorModeDialog() {
    val viewModelStoreOwner = koinInject<ViewModelStoreOwner>(qualifier = object : Qualifier {
        override val value: QualifierValue = Qualifiers.GLOBAL_VIEW_MODEL_STORE_OWNER
    })
    val settingsViewModel = koinViewModel<SettingsViewModel>(
        viewModelStoreOwner = viewModelStoreOwner
    )
    val paddings = LocalPaddings.current

    DialogScreen(
        modifier = Modifier.fillMaxWidth(),
        onBackAction = { settingsViewModel.onEvent(SettingsEvents.GoBack) },
        confirmButton = {
            ElevatedButtonImpl(
                onClick = {
                    settingsViewModel.onEvent(SettingsEvents.GoBack)
                }
            ) {
                TextImpl(
                    text = SharedStrings.Close.value,
                    textColor = colorScheme.primary
                )
            }
        }
    ) {
        DialogTittle(R.string.color_mode)
        Spacer(Modifier.padding(paddings.extraSmall))
        Content(
            currentColorMode = settingsViewModel.colorMode
        ) { colorMode ->
            settingsViewModel.onEvent(SettingsEvents.SetColorMode(colorMode))
        }
    }
}

@Composable
fun Content(
    currentColorMode: StateFlow<ColorMode>,
    onClick: (ColorMode) -> Unit
) {
    val selectedColorMode = currentColorMode.collectAsStateWithLifecycle()
    ColorMode.entries.forEach { colorMode ->
        val interactionSource = remember {
            MutableInteractionSource()
        }
        RadioButtonImpl(
            text = colorMode.name,
            selected = selectedColorMode.value == colorMode,
            mutableInteractionSource = interactionSource,
            onClick = {
                onClick(colorMode)
            }
        )
    }
}