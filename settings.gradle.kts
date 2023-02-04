pluginManagement {

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

}
dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
    }

}
rootProject.name = "Mivu"
include(":app")
include(":core:ui")
include(":core:model")
include(":core:data")
include(":feature:auth")
include(":feature:favorites")
include(":feature:search")
include(":feature:profile")
include(":feature:home")
include(":feature:moviedetails")
include(":core:network")
include(":core:database")
