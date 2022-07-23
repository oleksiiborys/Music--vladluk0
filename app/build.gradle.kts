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