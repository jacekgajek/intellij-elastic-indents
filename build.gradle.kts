plugins {
    id("org.jetbrains.intellij.platform") version "2.9.0"
    java
}

group = "io.github.heldev"
version = "3.0.0"


repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}
dependencies {
    intellijPlatform {
        create("IU", "2025.2")
    }
}
