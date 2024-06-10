//// Top-level build file where you can add configuration options common to all sub-projects/modules.
//
//buildscript {
//    repositories {
//        google()
//        mavenCentral()
//    }
//    dependencies {
//        classpath("com.android.tools.build:gradle:7.2.0")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.0")
//    }
//}
//
//allprojects {
//    repositories {
//        google()
//        mavenCentral()
//    }
//}
//
//tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
//}


// Top-level build file where you can add configuration options common to all sub-projects/modules.

// 项目根目录下的 build.gradle.kts

buildscript {
    val kotlin_version by extra("1.6.10")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        //noinspection UseTomlInstead
        classpath("com.android.tools.build:gradle:8.3.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}