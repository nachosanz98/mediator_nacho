name := """Mediator"""
organization := "com.nacho"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.12"

resolvers += "Akka library repository".at("https://repo.akka.io/maven")
val AkkaVersion = "2.9.0"

libraryDependencies ++= Seq(
  guice,
  javaJpa,
  jdbc,
  javaJdbc,
  "com.mysql" % "mysql-connector-j" % "8.0.33",
  "com.typesafe.akka" %% "akka-actor" % AkkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % AkkaVersion % Test
)
