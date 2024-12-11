plugins {
    id(ThunderbirdPlugins.Library.android)
}

android {
    namespace = "app.k9mail.legacy.folder"
}

dependencies {
    implementation(projects.mail.common)

    implementation(projects.core.mail.folder.api)
}
