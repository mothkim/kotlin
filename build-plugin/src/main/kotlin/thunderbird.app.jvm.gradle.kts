plugins {
    id("application")
    id("org.jetbrains.kotlin.jvm")
    id("thunderbird.quality.detekt.typed")
    id("thunderbird.quality.spotless")
}

java {
    sourceCompatibility = ThunderbirdProjectConfig.javaCompatibilityVersion
    targetCompatibility = ThunderbirdProjectConfig.javaCompatibilityVersion
}

configureKotlinJavaCompatibility()

dependencies {
    implementation(platform(libs.kotlin.bom))
    implementation(platform(libs.koin.bom))

    implementation(libs.bundles.shared.jvm.main)
    testImplementation(libs.bundles.shared.jvm.test)
}
