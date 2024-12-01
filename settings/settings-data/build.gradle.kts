plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    kotlin("plugin.serialization")
}

android {
    namespace = "com.olpl.settings_data"
    compileSdk = rootProject.ext.get("compileSdk") as Int

    defaultConfig {
        minSdk = rootProject.ext.get("minSdk") as Int
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = rootProject.ext.get("javaVersion") as JavaVersion
        targetCompatibility = rootProject.ext.get("javaVersion") as JavaVersion
    }
    kotlinOptions {
        jvmTarget = rootProject.ext.get("jvmTarget") as String
    }
}

dependencies {
    //Modules
    implementation(project(":settings:settings-domain"))

    //Serialization
    implementation(libs.kotlinx.serialization.json)

    //Koin
    implementation (libs.koin.android)
    implementation (libs.koin.annotations)
    ksp (libs.koin.ksp)

    //DataScore
    implementation(libs.androidx.datastore)

    implementation(libs.androidx.core.ktx)
}