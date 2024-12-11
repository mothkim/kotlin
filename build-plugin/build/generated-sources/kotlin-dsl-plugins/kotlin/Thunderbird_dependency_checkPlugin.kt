/**
 * Precompiled [thunderbird.dependency.check.gradle.kts][Thunderbird_dependency_check_gradle] script plugin.
 *
 * @see Thunderbird_dependency_check_gradle
 */
public
class Thunderbird_dependency_checkPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Thunderbird_dependency_check_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
