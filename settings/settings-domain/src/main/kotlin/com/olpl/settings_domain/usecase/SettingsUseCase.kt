package com.olpl.settings_domain.usecase

import com.olpl.settings_domain.R
import com.olpl.settings_domain.models.SettingsDto
import com.olpl.settings_domain.repositories.SettingsRepository
import com.olpl.utils.Responses
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.annotation.Factory

@Factory
class SettingsUseCase(
    private val rep: SettingsRepository
) {
    fun getSettingsData(): Flow<Responses<Flow<SettingsDto>>> = flow {
        emit(Responses.Loading())
        val settingsData = rep.getSettingsData()
        emit(Responses.Success(settingsData))
    }

    fun setColorMode(colorMode: String): Flow<Responses<Unit>> = flow {
        try {
            emit(Responses.Loading())
            rep.setColorMode(colorMode)
            emit(Responses.Success(Unit))
        } catch (e: Exception) {
            emit(Responses.Error(R.string.default_error_message))
        }
    }

    fun setColorPalette(colorPaletteId: Int): Flow<Responses<Unit>> = flow {
        try {
            emit(Responses.Loading())
            rep.setColorPalette(colorPaletteId)
            emit(Responses.Success(Unit))
        } catch (e: Exception) {
            emit(Responses.Error(R.string.default_error_message))
        }
    }

    fun setFontVariant(fontFamilyVariantId: Int): Flow<Responses<Unit>> = flow {
        try {
            emit(Responses.Loading())
            rep.setFontVariant(fontFamilyVariantId)
            emit(Responses.Success(Unit))
        } catch (e: Exception) {
            emit(Responses.Error(R.string.default_error_message))
        }
    }
}