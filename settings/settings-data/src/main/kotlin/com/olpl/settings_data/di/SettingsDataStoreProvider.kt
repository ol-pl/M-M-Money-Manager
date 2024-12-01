package com.olpl.settings_data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.olpl.settings_data.models.SettingsDtoEntity
import com.olpl.settings_data.serializers.SettingsDtoEntitySerializer
import kotlinx.coroutines.CoroutineScope
import org.koin.core.annotation.Single

@Single
fun settingsDataStoreProvider(
    context: Context,
    scope: CoroutineScope
): DataStore<SettingsDtoEntity> {
    return DataStoreFactory.create(
        serializer = SettingsDtoEntitySerializer,
        scope = scope,
        produceFile = { context.dataStoreFile("user_settings") }
    )
}