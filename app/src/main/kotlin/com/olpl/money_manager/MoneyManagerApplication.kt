package com.olpl.money_manager

import android.app.Application
import com.olpl.core_presentation.di.CorePresentationModule
import com.olpl.settings_data.di.SettingsDataModule
import com.olpl.settings_domain.di.SettingsDomainModule
import com.olpl.settings_presentation.di.SettingsPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class MoneyManagerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MoneyManagerApplication)
            modules(
                SettingsPresentationModule().module,
                SettingsDomainModule().module,
                SettingsDataModule().module,
                CorePresentationModule().module,
            )
        }
    }
}