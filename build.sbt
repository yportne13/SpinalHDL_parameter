
val spinalVersion = "1.10.0"

lazy val root = (project in file(".")).
  settings(
    Compile / scalaSource := baseDirectory.value / "hw" / "spinal",
    inThisBuild(List(
      organization := "com.github.spinalhdl",
      scalaVersion := "2.11.12",
      version      := "2.0.0"
    )),
    scalacOptions +=  s"-Xplugin:${new File(baseDirectory.value + s"/SpinalHDL/idslplugin/target/scala-2.11/spinalhdl-idsl-plugin_2.11-$spinalVersion.jar")}",
    scalacOptions += s"-Xplugin-require:idsl-plugin",
    name := "test_parameter"
  ).dependsOn(spinalHdlIdslPlugin, spinalHdlSim,spinalHdlCore,spinalHdlLib)

lazy val spinalHdlIdslPlugin = ProjectRef(file("SpinalHDL"), "idslplugin")
lazy val spinalHdlSim = ProjectRef(file("SpinalHDL"), "sim")
lazy val spinalHdlCore = ProjectRef(file("SpinalHDL"), "core")
lazy val spinalHdlLib = ProjectRef(file("SpinalHDL"), "lib")

javaOptions += "-Xmx2G"

fork := true
