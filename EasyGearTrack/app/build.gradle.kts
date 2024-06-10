//plugins {
//    id("com.android.application")
//    kotlin("android")
//}
//
//android {
//    compileSdkVersion(28)
//    buildToolsVersion("31.0.0")
//
//    defaultConfig {
//        applicationId = "your.application.id"
//        minSdkVersion(21)
//        targetSdkVersion(33)
//        versionCode = 1
//        versionName = "1.0"
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//        }
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//}
//
//dependencies {
//    implementation("androidx.appcompat:appcompat:1.4.0")
//    implementation("com.google.android.material:material:1.5.0-alpha01")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
//
//    // Add your other dependencies here
//}
//
//repositories {
//    google()
//    mavenCentral()
//}



import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 34
    buildToolsVersion = "31.0.0"
    namespace = "com.prog.easygeartrack"

    defaultConfig {
        applicationId = "com.prog.easygeartrack"
        minSdk = 21
        //noinspection EditedTargetSdkVersion,ExpiredTargetSdkVersion
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("com.google.code.gson:gson:2.8.6")


}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
