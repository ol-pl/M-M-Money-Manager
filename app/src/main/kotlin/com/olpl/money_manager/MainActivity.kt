package com.olpl.money_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.lifecycle.ViewModelStoreOwner
import com.olpl.core_ui.theme.MoneyManagerTheme
import com.olpl.core_ui.theme.util.ColorMode
import com.olpl.core_ui.util.Qualifiers
import com.olpl.settings_presentation.ui.SettingsScreenRoot
import com.olpl.settings_presentation.viewmodel.SettingsViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModelStoreOwner = koinInject<ViewModelStoreOwner>(
                qualifier = object : Qualifier {
                    override val value: QualifierValue = Qualifiers.GLOBAL_VIEW_MODEL_STORE_OWNER
                }
            )
            val settingsViewModel = koinViewModel<SettingsViewModel>(
                viewModelStoreOwner = viewModelStoreOwner
            )
            val colorMode = when (settingsViewModel.colorMode.value) {
                ColorMode.Auto -> isSystemInDarkTheme()
                ColorMode.Dark -> true
                ColorMode.Light -> false
            }
            MoneyManagerTheme(
                darkTheme = colorMode,
                paletteVariants = settingsViewModel.colorPalette.value,
                fontFamilyVariants = settingsViewModel.fontFamilyVariants.value
            ) {
                SettingsScreenRoot()
            }
        }
    }
}
