import java.util.Properties
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    //alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.mistake2"
    compileSdk = 34
   
    defaultConfig {
        applicationId = "com.example.mistake2"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

             val properties = Properties().apply {
                load(file("${rootDir}/apikeys.properties").inputStream())
            }
            val apiKey = properties.getProperty("YOUTUBE_API_KEY")
            if (apiKey.isNullOrBlank()) {
                throw GradleException("API Key is missing in apikeys.properties")
            }

            buildConfigField("String", "YOUTUBE_API_KEY", "\"AIzaSyCA_qi4YlcuyXVCWyUy7lSXY-CuCYrKAkM\"")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

dependencies {

    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp.logging)
    ksp(libs.room.compiler)
    implementation(platform(libs.androidx.compose.bom)) // BOM for Compose
    implementation(libs.navigation.compose)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.coil.compose)
    implementation(libs.androidx.activity.compose)

    // Core and Lifecycle
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // UI Testing
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // AndroidX and Material Components
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // TestingsymbolProcessorCla
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Use BOM for tests as well
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debugging
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}}

/*project.afterEvaluate{
    if (!project.hasProperty("YOUTUBE_API_KEY")) {
        throw  GradleException("API Key not found in local.properties")
    }
}*/
ksp {
    arg("room.incremental", "true")
}
dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
}

