ThisBuild / organization := "uk.co.alexknight"
ThisBuild / autoScalaLibrary := false
ThisBuild / scalaVersion := "3.1.2"
ThisBuild / scalacOptions := Seq(
  "-no-indent",
  "-old-syntax",
  "-encoding",  "utf-8",
  "-explain-types",
  "-Xfatal-warnings"
)
ThisBuild / version := "0.0.3"

val buildInfoRequirements = Seq[BuildInfoKey](name, version, scalaVersion)

val dependencies = Seq(
  "org.processing" % "core" % "3.3.7",
  "org.scala-lang" %% "scala3-library" % "3.1.0",
  // Testing
  "com.novocode" % "junit-interface" % "0.11" % Test,
  "org.scalactic" %% "scalactic" % "3.2.10",
  "org.scalatest" %% "scalatest" % "3.2.10" % Test
)

val engine = (project in file("engine"))
  .settings(
    name := "Processing Me Engine",
    buildInfoPackage := "uk.co.alexknight.processingme.engine",
    buildInfoKeys := buildInfoRequirements,
    libraryDependencies := dependencies
  )

val demo_app = (project in file("demo-app"))
  .dependsOn(engine)
  .settings(
    name := "Demo App",
    buildInfoPackage := "uk.co.alexknight.processingme.demoapp",
    buildInfoKeys := buildInfoRequirements,
    libraryDependencies := dependencies
  )

val root = (project in file("."))
  .settings(
    name := "Processing Me"
  )
  .aggregate(engine, demo_app)
