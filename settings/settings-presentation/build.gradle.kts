plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.olpl.settings_presentation"
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
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = rootProject.ext.get("jvmTarget") as String
    }
}

dependencies {
    //Modules
    implementation(project(":core:core-presentation"))
    implementation(project(":core:core-utils"))
    implementation(project(":settings:settings-domain"))

    //Koin
    implementation (libs.koin.androidx.compose)
    implementation (libs.koin.android)
    implementation (libs.koin.annotations)
    ksp (libs.koin.ksp)

    //Info bar
    implementation(libs.info.bar.compose)

    //Navigation
    implementation(libs.androidx.navigation.compose)

    //Serialization
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.core.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui)
}