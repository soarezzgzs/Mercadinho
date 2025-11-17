pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev") // ✅ necessário para Compose Multiplatform
    }
    plugins {
        // Android Gradle Plugin
        id("com.android.application") version "8.2.0"
        id("com.android.library") version "8.2.0"

        // Kotlin Multiplatform + Compose
        kotlin("multiplatform") version "2.0.21"
        kotlin("plugin.compose") version "2.0.21"
        id("org.jetbrains.compose") version "1.6.10"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev") // ✅ garante acesso às libs Compose
    }
}

rootProject.name = "Mercadinho"

// ✅ Módulos multiplataforma
include(":androidApp")
include(":shared")

// ℹ️ O módulo iOS será gerado como framework via Gradle e integrado no Xcode.
// Não precisa incluir ":iosApp" aqui — ele é gerenciado fora do Gradle.
