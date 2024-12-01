package com.olpl.settings_data.local

import androidx.datastore.core.DataStore
import com.olpl.settings_data.models.SettingsDtoEntity
import com.olpl.settings_data.models.mappers.mapToSettingsDto
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import org.koin.core.annotation.Factory

@Factory
class SettingsDataManager(
    private val dataStore: DataStore<SettingsDtoEntity>
) {
    val data = dataStore.data.map { value ->
        value.mapToSettingsDto()
    }

    suspend fun setColorMode(colorMode: String) {
        dataStore.updateData { currentData ->
            currentData.copy(
                colorMode = colorMode
            )
        }
    }

    suspend fun setColorPalette(colorPaletteId: Int) {
        dataStore.updateData { currentData ->
            currentData.copy(
                colorPaletteId = colorPaletteId
            )
        }
    }

    suspend fun setFontVariant(fontFamilyVariantId: Int) {
        dataStore.updateData { currentData ->
            currentData.copy(
                fontFamilyVariantId = fontFamilyVariantId
            )
        }
    }
}