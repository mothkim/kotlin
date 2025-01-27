/**
 * Precompiled [thunderbird.quality.spotless.root.gradle.kts][Thunderbird_quality_spotless_root_gradle] script plugin.
 *
 * @see Thunderbird_quality_spotless_root_gradle
 */
public
class Thunderbird_quality_spotless_rootPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Thunderbird_quality_spotless_root_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
