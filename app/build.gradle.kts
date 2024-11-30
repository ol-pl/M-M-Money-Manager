plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    kotlin("plugin.serialization")
}

android {
    namespace = "com.olpl.money_manager"
    compileSdk = rootProject.ext["compileSdk"] as Int

    defaultConfig {
        applicationId = "com.olpl.money_manager"
        minSdk = rootProject.ext["minSdk"] as Int
        targetSdk = rootProject.ext["targetSdk"] as Int
        versionCode = rootProject.ext["versionCode"] as Int
        versionName = rootProject.ext["versionName"] as String
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = rootProject.ext["javaVersion"] as JavaVersion
        targetCompatibility = rootProject.ext["javaVersion"] as JavaVersion
    }
    kotlinOptions {
        jvmTarget = rootProject.ext["jvmTarget"] as String
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    //Modules
    implementation(project(":core:core-presentation"))

    //Navigation
    implementation (libs.androidx.navigation.compose)

    //Serialization
    implementation(libs.kotlinx.serialization.json)

    //Info bar
    implementation(libs.info.bar.compose)

    //Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    //Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
}