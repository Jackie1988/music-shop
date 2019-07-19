name := "music-shop"
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(PlayKeys.playDefaultPort := 7001)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test
libraryDependencies ++= Seq(
  //"org.mongodb" %% "casbah" % "2.6.0",
  "org.slf4j" % "slf4j-simple" % "1.6.4",
  "org.reactivemongo" %% "reactivemongo" % "0.18.1"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

resolvers += "Tim Tennant's repo" at "http://dl.bintray.com/timt/repo/"

libraryDependencies += "io.shaka" %% "naive-http" % "104"
