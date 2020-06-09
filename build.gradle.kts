plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm")
}

val ver = "0.1"

group = "dev.bfengineering"
version = ver

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}

publishing {
    publications {
        repositories.maven {
            url = uri("https://deps.bfengineering.dev/repository/internal")
            credentials {
                username = project.property("depsUsername").toString()
                password = project.property("depsPassword").toString()
            }
        }

        register("maven", MavenPublication::class) {
            artifacts {
                groupId = "dev.bfengineering"
                artifactId = "ktchartjs"
                version = "$ver"
                artifact("build/libs/ktchartjs-$ver.jar")
            }
        }


    }
}