// responsible to providing the main entry point to the service
plugins {
    application
}
application {
    mainClass = "com.example.demo.Demo1ApplicationKt"
}

dependencies {
    implementation(libs.spring.boot.starter.web)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.stdlib.jdk8)

    testImplementation(libs.spring.boot.starter.test)

    developmentOnly(libs.spring.boot.devtools)

    // include all other connector projects here, so the endpoints provided by them will be served by the application
    runtimeOnly(project(":dummy"))
}
