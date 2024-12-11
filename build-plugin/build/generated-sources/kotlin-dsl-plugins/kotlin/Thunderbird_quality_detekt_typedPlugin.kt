/**
 * Precompiled [thunderbird.quality.detekt.typed.gradle.kts][Thunderbird_quality_detekt_typed_gradle] script plugin.
 *
 * @see Thunderbird_quality_detekt_typed_gradle
 */
public
class Thunderbird_quality_detekt_typedPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Thunderbird_quality_detekt_typed_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
