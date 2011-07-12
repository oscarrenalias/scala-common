import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
val specs = "org.scala-tools.testing" %% "specs" % "1.6.8" % "test"
val log_lib = "ch.qos.logback" % "logback-classic" % "0.9.26"
val configgy = "net.lag" % "configgy" % "2.0.0" intransitive()
}