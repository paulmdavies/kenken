import sbt._
import Keys._

object Kenken extends Build
{
    lazy val kenken = Project(
        id = "kenken",
        base = file("."),
        settings = Project.defaultSettings ++ Seq(
            libraryDependencies ++= Seq(
                "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"
            )
        )
    )
}
