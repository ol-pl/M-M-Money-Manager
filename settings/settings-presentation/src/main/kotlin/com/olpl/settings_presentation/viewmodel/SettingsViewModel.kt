package com.olpl.settings_presentation.viewmodel

import com.olpl.core_presentation.theme.util.ColorMode
import com.olpl.core_presentation.theme.util.FontFamilyVariants
import com.olpl.core_presentation.theme.util.PaletteVariants
import com.olpl.core_presentation.viewmodel.ViewModelExp
import com.olpl.settings_domain.usecase.SettingsUseCase
import com.olpl.settings_presentation.R
import com.olpl.settings_presentation.viewmodel.events.SettingsEvents
import com.olpl.settings_presentation.viewmodel.events.SettingsUiEvents
import com.olpl.utils.Responses
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SettingsViewModel(
    private val settingsUseCase: SettingsUseCase
) : ViewModelExp<SettingsEvents, SettingsUiEvents>() {
    private val _colorMode = MutableStateFlow<ColorMode>(ColorMode.Auto)
    val colorMode: StateFlow<ColorMode> = _colorMode.asStateFlow()

    private val _colorPalette = MutableStateFlow<PaletteVariants>(PaletteVariants.P1)
    val colorPalette: StateFlow<PaletteVariants> = _colorPalette.asStateFlow()

    private val _fontFamilyVariants =
        MutableStateFlow<FontFamilyVariants>(FontFamilyVariants.Roboto)
    val fontFamilyVariants: StateFlow<FontFamilyVariants> = _fontFamilyVariants.asStateFlow()

    init {
        launchSettingsObserver()
    }

    override fun onEvent(event: SettingsEvents) {
        when (event) {
            is SettingsEvents.SetColorMode -> {
                setColorMode(event.colorMode)
            }

            is SettingsEvents.SetColorPalette -> TODO()
            is SettingsEvents.SetFont -> TODO()
            SettingsEvents.GoBack -> {
                sendUiEvent(SettingsUiEvents.GoBack)
            }

            SettingsEvents.OnColorModeCardClick -> {
                sendUiEvent(SettingsUiEvents.OpenColorModeDialog)
            }
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
                _colorPalette.update { PaletteVariants.getById(newData.colorPaletteId) }
                _colorMode.update { ColorMode.valueOf(newData.colorMode) }
                _fontFamilyVariants.update { FontFamilyVariants.getById(newData.fontFamilyVariantId) }
            }
        }
    }

}