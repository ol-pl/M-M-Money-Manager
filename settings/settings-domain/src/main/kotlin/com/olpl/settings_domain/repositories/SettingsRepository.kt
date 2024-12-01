package com.olpl.settings_domain.repositories

import com.olpl.settings_domain.models.SettingsDto
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    suspend fun getSettingsData(): Flow<SettingsDto>

    suspend fun setColorMode(colorMode: String)

    suspend fun setColorPalette(colorPaletteId: Int)

    suspend fun setFontVariant(fontFamilyVariantId: Int)
}