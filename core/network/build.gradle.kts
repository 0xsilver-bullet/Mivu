import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.8.10"
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.silverbullet.core.network"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val tmdbUrl = gradleLocalProperties(rootDir)
            .getProperty("TMDB_URL")
        val tmdbApiKey = gradleLocalProperties(rootDir)
            .getProperty("TMDB_API_KEY")

        buildConfigField("String","TMDBUrl",tmdbUrl)
        buildConfigField("String","TMDBApiKey",tmdbApiKey)
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(Modules.coreModel))

    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)

    implementation(Kotlin.kotlinxSerialization)
    implementation(Retrofit.retrofit)
    implementation(Retrofit.kotlinxSerializationConverter)
    implementation(OkHttp.loggingInterceptor)

    testImplementation(Testing.junit4)
    testImplementation(Testing.composeUiTest)
}