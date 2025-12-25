// file: stonecutter.gradle.kts
plugins {
    id("dev.kikugie.stonecutter")
    id("net.neoforged.moddev") version "2.0.119" apply false
    // id("me.modmuss50.mod-publish-plugin") version "1.0.+" apply false
}

stonecutter active "1.21.8"

/*
// Make newer versions be published last
stonecutter tasks {
    order("publishModrinth")
    order("publishCurseforge")
}
 */

// See https://stonecutter.kikugie.dev/wiki/config/params
stonecutter parameters {
    swaps["mod_version"] = "\"" + property("mod.version") + "\";"
    swaps["minecraft"] = "\"" + node.metadata.version + "\";"
    constants["release"] = property("mod.id") != "template"
}

fun readActiveProjectName(): String {
    val text = file("stonecutter.gradle.kts").readText()
    val m = Regex("""stonecutter\s+active\s+"([^"]+)"""").find(text)
        ?: error("Could not find `stonecutter active \"...\"` in stonecutter.gradle.kts")
    return m.groupValues[1]
}

fun isVersionNode(p: Project): Boolean =
    p.projectDir.parentFile?.name == "versions"

tasks.register("runDatagenAll") {
    group = "stonecutter"
    description = "Runs datagen for ALL Stonecutter version projects."
    val nodes = subprojects.filter(::isVersionNode)
    dependsOn(nodes.map { "${it.path}:runDatagen" })
}

tasks.register("runDatagenActive") {
    group = "stonecutter"
    description = "Runs datagen only for the CURRENT active Stonecutter project."
    val active = readActiveProjectName()
    dependsOn(":$active:runDatagen")
}

tasks.register("runClientActive") {
    group = "stonecutter"
    description = "Runs the client only for the CURRENT active Stonecutter project."
    val active = readActiveProjectName()
    dependsOn(":$active:runClient")
}

tasks.register("runServerActive") {
    group = "stonecutter"
    description = "Runs the server only for the CURRENT active Stonecutter project."
    val active = readActiveProjectName()
    dependsOn(":$active:runServer")
}
