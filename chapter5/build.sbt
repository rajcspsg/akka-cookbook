name := "chapter5"

version := "1.0"

scalaVersion := "2.12.3"

organization := "packt"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.4"

libraryDependencies += "com.typesafe.akka" %%  "akka-testkit" % "2.5.4" % "test"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

description := "Scheduling Actors and Other Utilities"
