/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    `java-library`
    id("me.champeau.jmh").version("0.6.6")
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.2")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.2")
}

group = "org.roon"
version = "0.0.1-SNAPSHOT"
description = "JMHPractice"
java.sourceCompatibility = JavaVersion.VERSION_1_8

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
