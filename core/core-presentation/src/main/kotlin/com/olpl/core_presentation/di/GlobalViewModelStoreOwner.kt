package com.olpl.core_presentation.di

import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.olpl.core_presentation.util.Qualifiers
import org.koin.core.annotation.Qualifier
import org.koin.core.annotation.Single

@Single
@Qualifier(name = Qualifiers.GLOBAL_VIEW_MODEL_STORE_OWNER)
fun provideGlobalViewModelStoreOwner(): ViewModelStoreOwner = object : ViewModelStoreOwner {
    override val viewModelStore: ViewModelStore = ViewModelStore()
}