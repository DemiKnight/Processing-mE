ThisBuild / organization := "uk.co.alexknight"
ThisBuild / scalaVersion := "3.1.0"

val dependencies = Seq(
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.processing" % "core" % "3.3.7"
)

lazy val engine = project.in(file("engine"))
  .settings(
    version := "0.0.1",
    name := "processing-me",
    libraryDependencies := dependencies
  )

lazy val demo_app = project.in(file("demo-app"))
  .dependsOn(engine)
  .settings(
    name := "p-me-demo-app",
    version := "0.0.1",
    libraryDependencies := dependencies
  )

lazy val root = project
  .in(file("."))
  .aggregate(engine, demo_app)
