package com.olpl.settings_data.serializers

import androidx.datastore.core.Serializer
import com.olpl.settings_data.models.SettingsDtoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object SettingsDtoEntitySerializer : Serializer<SettingsDtoEntity> {
    override val defaultValue: SettingsDtoEntity
        get() = SettingsDtoEntity()

    override suspend fun readFrom(input: InputStream): SettingsDtoEntity {
        return try {
            Json.decodeFromString(
                deserializer = SettingsDtoEntity.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            defaultValue
        }
    }

    override suspend fun writeTo(
        value: SettingsDtoEntity,
        output: OutputStream
    ) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = SettingsDtoEntity.serializer(),
                    value = value
                ).encodeToByteArray()
            )
        }
    }
}