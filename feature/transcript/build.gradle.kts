plugins {
    id("opencode.android.feature")
}

android {
    namespace = "ai.opencode.feature.transcript"
}

// The graph is acyclic: media, voice, system < transcript, composer, settings < session < drawer <
// app.
dependencies {
    api(project(":feature:media"))
    // BackHandler dismisses text selection on Android versions without predictive back.
    implementation(libs.androidx.activity.compose)
    implementation(libs.coil.compose)
    implementation(libs.jlatexmath.android)
    // android.icu (time stamps), MimeTypeMap/Uri/ClipData (drag payloads) in JVM tests.
    testImplementation(libs.robolectric)
}
