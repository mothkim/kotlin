/**
 * Precompiled [thunderbird.app.android.compose.gradle.kts][Thunderbird_app_android_compose_gradle] script plugin.
 *
 * @see Thunderbird_app_android_compose_gradle
 */
public
class Thunderbird_app_android_composePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Thunderbird_app_android_compose_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
