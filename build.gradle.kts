// unfortunately in this version of gradle the syntax for plugin declaration is quite fixed,
// that's why we need to repeat it in the `allprojects` section
plugins {
    with(libs.plugins) {
        listOf(
            springframework.boot,
            kotlin.jvm,
            kotlin.plugin.spring,
        ).forEach {
            alias(it)
        }
    }
}

allprojects {
    group = "io.bryter"

    repositories {
        mavenCentral() // dependency repository
    }

    // apply plugins for all subprojects
    with(rootProject.libs.plugins) {
        listOf(
            springframework.boot,
            kotlin.jvm,
            kotlin.plugin.spring,
        ).forEach {
            plugins.apply(it.get().pluginId)
        }
    }

    // set consistent Java versions for JVM Toolchain and compilations across all local and remote locations
    val javaVersion = rootProject.libs.versions.java.get()
    kotlin {
        jvmToolchain(javaVersion.toInt())
    }
    tasks.compileKotlin {
        kotlinOptions {
            jvmTarget = javaVersion
        }
    }

    // add test tasks for all subprojects
    tasks.test {
        useJUnitPlatform()
    }
}
