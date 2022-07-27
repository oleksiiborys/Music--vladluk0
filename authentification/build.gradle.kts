plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}
android {
    compileSdk = 32

    buildTypes {
        getByName("release") {
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
        freeCompilerArgs +=
            "-Xjvm-default=all"

    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
dependencies {

    implementation(project(mapOf("path" to ":common-ui-compose")))
    implementation(project(mapOf("path" to ":module-injector")))
    implementation(project(mapOf("path" to ":core-firebase")))
    implementation(project(mapOf("path" to ":base-android")))

    implementation(libs.androidXCore)
    implementation(libs.bundles.composeMaterial)
    implementation(libs.composeNavigation)
    implementation(libs.firebaseAuth)
    implementation(libs.authPlayService)
    implementation(libs.composeTooling)
    implementation(libs.firebaseBom)
    implementation(libs.firebaseFireStore)
    implementation(libs.coroutines)
    implementation(libs.coroutinesPlayService)
    implementation(libs.bundles.dagger)
    kapt(libs.bundles.daggerKapt)
}