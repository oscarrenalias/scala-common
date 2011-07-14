Renalias.net Scala-common
=========================
Scala classes that I keep reusing in every pet project of mine.

The repository can be cloned to retrieve the most recent version, or the latest published version can be retrieved from my personal Maven repository. 

SBT
---
If using SBT, add the following to your Project.scala file:

```scala
val repo = "Renalias.net Maven Repository" at "http://phunkphorce.github.com/maven"
val scala_common = "net.renalias" %% "scala-common" % "20110712"
```

The libraries are cross-compiled for Scala 2.9.0 and 2.9.0-1.

Maven
-----
Add the following repository to your pom.xml file:

```xml
<repository>
   <id>renaliasnetRepository</id>
   <name>renalias.net Repository</name>
   <url>http://phunkphorce.github.com/maven/</url>
</repository>
```

And then declare the dependency:

```xml
<dependency>
  <groupId>net.renalias</groupId>
  <artifactId>scala-common_2.9.0-1</artifactId>
  <version>20110712</version>
</dependency>
```