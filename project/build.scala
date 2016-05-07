import sbt._
import Keys._

object Kenken extends Build
{
    lazy val kenken = Project(
        id = "kenken",
        base = file("."),
        settings = Project.defaultSettings ++ Seq(
            scalaVersion := "2.11.8",
            libraryDependencies ++= Seq(
                "org.scalatest" %% "scalatest" % "2.2.6" % "test"
            )
        )
    )
}
