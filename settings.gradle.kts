rootProject.name = "demo1"

// plugin repositories
pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0" // provides a repository for downloading JVMs
}

// include all subprojects here, so Gradle would know about them
include("application")
include("dummy")
