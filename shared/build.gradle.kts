plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("com.google.devtools.ksp") version "1.9.20-1.0.14"
    id("kotlinx-serialization")
    id("de.jensklingenberg.ktorfit") version "1.10.0"
}

kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    jvm()
    
    sourceSets {
        commonMain.dependencies {
            // Ktor & Ktorfit
            implementation(libs.ktorfit.lib)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)

            // Coroutines
            implementation(libs.kotlinx.coroutines.core)

            // DI - Kodein
            implementation(libs.kodein.di)
        }
    }
}

dependencies {
    with("de.jensklingenberg.ktorfit:ktorfit-ksp:1.10.0") {
        add("kspCommonMainMetadata", this)
        add("kspJvm", this)
        add("kspJvmTest", this)
        add("kspAndroid", this)
        add("kspAndroidTest", this)
        add("kspIosX64", this)
        add("kspIosX64Test", this)
        add("kspIosArm64", this)
        add("kspIosArm64Test", this)
        add("kspIosSimulatorArm64", this)
        add("kspIosSimulatorArm64Test", this)
    }
}

android {
    namespace = "com.sdk.klove.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
