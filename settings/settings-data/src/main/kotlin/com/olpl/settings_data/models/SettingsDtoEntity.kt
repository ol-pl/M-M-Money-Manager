package com.olpl.settings_data.models

import kotlinx.serialization.Serializable

@Serializable
data class SettingsDtoEntity(
    val colorPaletteId: Int = 1,
    val colorMode: String = "Auto",
    val fontFamilyVariantId: Int = 1
)
