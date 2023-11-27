name := """Mediator"""
organization := "com.nacho"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.10"

//New guice dependencies due to Java 17.
libraryDependencies ++= Seq(
  "com.google.inject"            % "guice"                % "5.1.0",
  "com.google.inject.extensions" % "guice-assistedinject" % "5.1.0"
)

libraryDependencies += guice

libraryDependencies ++=Seq("com.typesafe.play" %% "play" % "2.8.18")

//DB configuration and evolutions
libraryDependencies ++= Seq(
  javaJdbc
)

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "8.0.31"
)