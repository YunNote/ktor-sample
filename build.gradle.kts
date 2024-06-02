val kotlin_version: String by project
val logback_version: String by project
val ktorm_version = "4.0.0"
val mysql_version = "8.0.33"
val hikari_version = "5.1.0"

plugins {
    kotlin("jvm") version "2.0.0"
    id("io.ktor.plugin") version "2.3.11"
    kotlin("plugin.serialization") version "2.0.0"
}

group = "com.yunnote"
version = "0.0.1"


application {
    mainClass.set("com.yunnote.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.ktorm:ktorm-core:$ktorm_version")
    implementation("org.ktorm:ktorm-jackson:$ktorm_version")
    implementation("org.ktorm:ktorm-support-mysql:$ktorm_version")

    implementation("mysql:mysql-connector-java:$mysql_version")
    implementation("com.zaxxer:HikariCP:$hikari_version")

    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.11")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.11")

    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
