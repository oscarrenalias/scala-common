import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {

  // generate javadoc and source packages
  override def packageDocsJar = defaultJarPath("-javadoc.jar")
  override def packageSrcJar= defaultJarPath("-sources.jar")
  val sourceArtifact = Artifact.sources(artifactID)
  val docsArtifact = Artifact.javadoc(artifactID)
  override def packageToPublishActions = super.packageToPublishActions ++ Seq(packageDocs, packageSrc)

  // publish content to my local maven repository (currently a git repo in github.com)
  override def managedStyle = ManagedStyle.Maven
  val publishTo = Resolver.file("renalias-repo", new java.io.File("..\\phunkphorce.github.com\\maven"))

  val specs = "org.scala-tools.testing" %% "specs" % "1.6.8" % "test"
  val log_lib = "ch.qos.logback" % "logback-classic" % "0.9.26"

  // this custom version of configgy is in my own maven repository
  val renalias_repo = "renalias.net Repository" at "http://phunkphorce.github.com/maven"
  val configgy = "net.lag" %% "configgy-nolog" % "2.0.2" withSources()
}