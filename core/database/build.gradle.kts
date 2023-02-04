plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.silverbullet.core.database"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(Modules.coreModel))

    implementation(Room.runtime)
    kapt(Room.compiler)
    implementation(Room.roomKtx)

    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)

    testImplementation(Testing.junit4)
    testImplementation(Testing.composeUiTest)

    androidTestImplementation(Testing.composeUiTest)
    androidTestImplementation(Testing.junitAndroidExt)
}