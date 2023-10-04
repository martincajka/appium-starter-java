
plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

val allureVersion = "2.23.0"
val junit5Version = "5.9.2"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation("io.appium:java-client:8.5.1")
    testImplementation("io.qameta.allure:allure-java-commons:$allureVersion")
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.qameta.allure:allure-java-commons")
}




