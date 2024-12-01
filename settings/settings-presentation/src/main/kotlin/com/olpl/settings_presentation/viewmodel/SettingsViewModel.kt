package com.olpl.settings_presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.olpl.core_ui.theme.util.ColorMode
import com.olpl.core_ui.theme.util.FontFamilyVariants
import com.olpl.core_ui.theme.util.PaletteVariants
import com.olpl.core_ui.viewmodel.ViewModelExp
import com.olpl.settings_domain.usecase.SettingsUseCase
import com.olpl.settings_presentation.R
import com.olpl.settings_presentation.viewmodel.events.SettingsEvents
import com.olpl.settings_presentation.viewmodel.events.SettingsUiEvents
import com.olpl.utils.Responses
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SettingsViewModel(
    private val settingsUseCase: SettingsUseCase
) : ViewModelExp<SettingsEvents, SettingsUiEvents>() {
    private val _colorMode = mutableStateOf<ColorMode>(ColorMode.Auto)
    val colorMode: State<ColorMode> = _colorMode

    private val _colorPalette = mutableStateOf<PaletteVariants>(PaletteVariants.P1)
    val colorPalette: State<PaletteVariants> = _colorPalette

    private val _fontFamilyVariants = mutableStateOf<FontFamilyVariants>(FontFamilyVariants.Roboto)
    val fontFamilyVariants: State<FontFamilyVariants> = _fontFamilyVariants

    init {
        launchSettingsObserver()
    }

    override fun onEvent(event: SettingsEvents) {
        when (event) {
            is SettingsEvents.SetColorMode -> {
            }

            is SettingsEvents.SetColorPalette -> TODO()
            is SettingsEvents.SetFont -> TODO()
        }
    }

    private fun setColorMode(colorMode: ColorMode) {
        settingsUseCase.setColorMode(colorMode.name).onEach { response ->
            when (response) {
                is Responses.Error<Unit> -> showInfoBar(text = response.message)
                is Responses.Loading<Unit> -> Unit
                is Responses.Success<Unit> -> showInfoBar(R.string.successfully_update)
            }
        }.launchIn(dataScope)
    }

    private fun setColorPalette(paletteVariants: PaletteVariants) {
        settingsUseCase.setColorPalette(paletteVariants.id).onEach { response ->
            when (response) {
                is Responses.Error<Unit> -> showInfoBar(text = response.message)
                is Responses.Loading<Unit> -> Unit
                is Responses.Success<Unit> -> showInfoBar(R.string.successfully_update)
            }
        }.launchIn(dataScope)
    }

    private fun setFont(fontFamilyVariants: FontFamilyVariants) {
        settingsUseCase.setFontVariant(fontFamilyVariants.id).onEach { response ->
            when (response) {
                is Responses.Error<Unit> -> showInfoBar(text = response.message)
                is Responses.Loading<Unit> -> Unit
                is Responses.Success<Unit> -> showInfoBar(R.string.successfully_update)
            }
        }.launchIn(dataScope)
    }

    private fun launchSettingsObserver() {
        dataScope.launch {
            val settingsData = settingsUseCase.getSettingsData().firstOrNull { responses ->
                responses is Responses.Success
            } as? Responses.Success
            settingsData?.data?.collectLatest { newData ->
                _colorMode.value = ColorMode.valueOf(newData.colorMode)
                _colorPalette.value = PaletteVariants.getById(newData.colorPaletteId)
                _fontFamilyVariants.value = FontFamilyVariants.getById(newData.fontFamilyVariantId)
            }
        }
    }

}