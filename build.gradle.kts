// Top-level build file where you can add configuration options common to all sub-projects/modules.
ext {
    set("compileSdk", 35)
    set("targetSdk", 35)
    set("minSdk", 26)

    set("versionName", "0.0.1")
    set("versionCode", 1)

    set("javaVersion", JavaVersion.VERSION_11)
    set("jvmTarget", "11")
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.android.library) apply false
    kotlin("plugin.serialization") version "2.1.0" apply false
}