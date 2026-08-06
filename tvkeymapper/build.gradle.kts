plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "io.github.rodinia.tvkeymapper"

    compileSdk = 35

    defaultConfig {
        applicationId = "io.github.rodinia.tvkeymapper"
        minSdk = 23
        targetSdk = 35

        versionCode = 2
        versionName = "2.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }

        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
}

