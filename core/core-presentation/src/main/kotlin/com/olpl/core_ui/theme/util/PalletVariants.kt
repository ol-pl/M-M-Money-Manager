package com.olpl.core_ui.theme.util

import com.olpl.core_ui.R
import com.olpl.utils.StringId

sealed class PaletteVariants(
    val title: StringId,
    val id: Int
) {
    data object P1 : PaletteVariants(R.string.palette_1, 1)
    data object P2 : PaletteVariants(R.string.palette_2, 2)

    companion object {
        fun getById(id: Int): PaletteVariants = when (id) {
            1 -> P1
            2 -> P2
            else -> P1
        }
    }
}
