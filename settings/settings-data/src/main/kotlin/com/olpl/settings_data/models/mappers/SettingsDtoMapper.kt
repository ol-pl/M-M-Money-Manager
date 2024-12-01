package com.olpl.settings_data.models.mappers

import com.olpl.settings_data.models.SettingsDtoEntity
import com.olpl.settings_domain.models.SettingsDto

fun SettingsDto.mapToSettingsDtoEntity(): SettingsDtoEntity {
    return SettingsDtoEntity(
        colorPaletteId = colorPaletteId,
        colorMode = colorMode,
        fontFamilyVariantId = fontFamilyVariantId
    )
}

fun SettingsDtoEntity.mapToSettingsDto(): SettingsDto {
    return SettingsDto(
        colorPaletteId = colorPaletteId,
        colorMode = colorMode,
        fontFamilyVariantId = fontFamilyVariantId
    )
}