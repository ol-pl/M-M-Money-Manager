package com.olpl.settings_data.repositories

import com.olpl.settings_data.local.SettingsDataManager
import com.olpl.settings_domain.models.SettingsDto
import com.olpl.settings_domain.repositories.SettingsRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class SettingsRepositoryImpl(
    private val dataManager: SettingsDataManager
) : SettingsRepository {
    override suspend fun getSettingsData(): Flow<SettingsDto> {
        return dataManager.data
    }

    override suspend fun setColorMode(colorMode: String) {
        dataManager.setColorMode(colorMode)
    }

    override suspend fun setColorPalette(colorPaletteId: Int) {
        dataManager.setColorPalette(colorPaletteId)
    }

    override suspend fun setFontVariant(fontFamilyVariantId: Int) {
        dataManager.setFontVariant(fontFamilyVariantId)
    }
}