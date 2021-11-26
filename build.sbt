ThisBuild / organization := "uk.co.alexknight"
ThisBuild / autoScalaLibrary := false

val ScalaVersion = "3.1.0"

val dependencies = Seq(
  "org.processing" % "core" % "3.3.7",
  "org.scala-lang" %% "scala3-library" % "3.1.0",
  // Testing
  "com.novocode" % "junit-interface" % "0.11" % Test,
  "org.scalactic" %% "scalactic" % "3.2.10",
  "org.scalatest" %% "scalatest" % "3.2.10" % Test,
)

lazy val engine = project.in(file("engine"))
  .settings(
    version := "0.0.1",
    scalaVersion := ScalaVersion,
    name := "processing-me",
    libraryDependencies := dependencies
  )

lazy val demo_app = project.in(file("demo-app"))
  .dependsOn(engine)
  .settings(
    name := "demo-app",
    scalaVersion := ScalaVersion,
    version := "0.0.1",
    libraryDependencies := dependencies
  )

lazy val root = project
  .in(file("."))
  .aggregate(engine, demo_app)
