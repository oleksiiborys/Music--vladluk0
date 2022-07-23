plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {
    val compileSdk = 32

    defaultConfig {
        val applicationId = "com.example.music"
        val minSdk = 21
        val targetSdk = 32
        val versionCode = 1
        val versionName = "1.0"

        val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            val useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            val minifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        val sourceCompatibility = JavaVersion.VERSION_1_8
        val targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs +=
                "-Xjvm-default=all"

    }
    buildFeatures {
        val compose = true
    }
    composeOptions {
        val kotlinCompilerExtensionVersion = "1.3.0-alpha01"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }


}

dependencies {
    api(":navigation")
    api(":core-network")
    api(":authentification")
    api(":module-injector")

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.compose.material3:material3:1.0.0-alpha14")
    implementation("androidx.compose.material3:material3-window-size-class:1.0.0-alpha14")
    implementation("androidx.activity:activity-compose:1.5.0")
    implementation("com.google.firebase:firebase-auth-ktx:21.0.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.0-alpha01")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.0-alpha01")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.0-alpha01")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha03")

    implementation(libs.bundles.compose)
    //lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.0")

    //lifecycle compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha01")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //dagger
    implementation("com.google.dagger:dagger:2.42")
    kapt("com.google.dagger:dagger-compiler:2.42")

    //compose
    implementation("androidx.compose.runtime:runtime-livedata:1.3.0-alpha01")

    //coil
    implementation("io.coil-kt:coil-compose:2.1.0")

    //navigation
    implementation("androidx.navigation:navigation-compose:2.5.0")

    //
    implementation("com.google.accompanist:accompanist-swiperefresh:0.24.11-rc")

    //firebase
    api("com.google.firebase:firebase-bom:30.3.0")
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    //Play Services
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:20.2.0")
    implementation("com.google.android.gms:play-services-auth:1.6.0")
}