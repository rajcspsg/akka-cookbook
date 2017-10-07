name := "akka-cookbook"

version := "1.0"

scalaVersion := "2.12.3"

lazy val buildSettings = Seq(
    organization := "packt",
    version := "1.0",
    scalaVersion := "2.12.3"
)

lazy val chapter1 = (project in file("chapter1")).settings(buildSettings).settings(
  name := "chapter1",
  description := "Diving Into Akka"
)


lazy val chapter2 = (project in file("chapter2")).settings(buildSettings).settings(
  name := "chapter2",
  description := "Suprevision And Monitoring"
)
