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


lazy val chapter3 = (project in file("chapter3")).settings(buildSettings).settings(
  name := "chapter3",
  description := "Routing Messagaes"
)

lazy val chapter4 = (project in file("chapter4")).settings(buildSettings).settings(
  name := "chapter4",
  description := "Using Futures And Agents"
)

lazy val chapter5 = (project in file("chapter5")).settings(buildSettings).settings(
  name := "chapter5",
  description := "Scheduling Actors and Other Utilities"
)
