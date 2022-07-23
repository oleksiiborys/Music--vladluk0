plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.music"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs +=
                "-Xjvm-default=all"

    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeUi.get()
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

    implementation(libs.bundles.compose)
    implementation(libs.bundles.composeMaterial)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.dagger)
    implementation(libs.androidXCore)
    implementation(libs.androidXLifecycle)
    implementation(libs.composeActivity)
    implementation(libs.composeConstraint)
    implementation(libs.composeLiveData)
    implementation(libs.composeCoil)
    implementation(libs.composeNavigation)
    implementation(libs.accompanistSwipeRefresh)
    implementation(libs.firebaseBom)
    implementation(libs.firebaseAnalytics)
    implementation(libs.firebaseAuth)
    implementation(libs.firebaseFireStore)
    implementation(libs.coroutinesPlayService)
    implementation(libs.authPlayService)
}