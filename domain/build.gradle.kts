plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}

dependencies {
    testImplementation("junit:junit:4.13.2")

    implementation("io.reactivex.rxjava3:rxjava:3.1.6")
}