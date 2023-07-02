plugins {
    kotlin("js") version "1.8.21"
}

group = "io.github.found_cake"
version = "1.0-SNAPSHOT"

fun kotlinw(target: String): String{
    val version = "18.2.0-pre.573"
    return "org.jetbrains.kotlin-wrappers:kotlin-$target:$version"
}

fun kotlinw(target: String, version: String): String
    = "org.jetbrains.kotlin-wrappers:kotlin-$target:$version"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlinw("react"))
    implementation(kotlinw("react-dom"))
    implementation(kotlinw("emotion", "11.11.1-pre.583"))
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
}