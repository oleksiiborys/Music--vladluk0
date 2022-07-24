enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    /*versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }*/
}
rootProject.name = "Music"
include (":app")
include (":navigation")
include (":module-injector")
include (":addArtist")
include (":core-network")
include (":authentification")
include(":common-ui-compose")
