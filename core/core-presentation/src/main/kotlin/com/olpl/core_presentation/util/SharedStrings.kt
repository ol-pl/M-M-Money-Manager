package com.olpl.core_presentation.util

import com.olpl.core_presentation.R
import com.olpl.utils.StringId

sealed class SharedStrings(val value: StringId) {
    data object Close : SharedStrings(R.string.close)
}