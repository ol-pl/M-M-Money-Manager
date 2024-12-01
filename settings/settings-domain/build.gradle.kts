plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.olpl.settings_domain"
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
    implementation(project(":core:core-utils"))

    //Koin
    implementation (libs.koin.android)
    implementation (libs.koin.annotations)
    ksp (libs.koin.ksp)

    implementation(libs.androidx.core.ktx)
}