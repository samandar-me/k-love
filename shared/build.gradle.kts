plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("com.google.devtools.ksp") version "1.9.20-1.0.14"
    id("kotlinx-serialization")
    id("de.jensklingenberg.ktorfit") version "1.10.0"
}

val ktorVersion = "2.3.4"
val ktorfitVersion = "1.10.0"

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
            implementation("de.jensklingenberg.ktorfit:ktorfit-lib:$ktorfitVersion")
            //implementation("de.jensklingenberg.ktorfit:ktorfit-lib-light:$ktorfitVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

            //Only needed when you want to use Kotlin Serialization
            implementation("io.ktor:ktor-client-serialization:$ktorVersion")
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
        }
    }
}

dependencies {
    with("de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion") {
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
