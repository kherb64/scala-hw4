
name := "hw4"
version := "1.17.0"
scalaVersion := "2.12.8"
sbtVersion := "1.2.8"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"
  , "org.scala-lang.modules" % "scala-xml_2.12" % "1.0.6"
  , "com.typesafe.akka" % "akka-actor_2.12" % "2.5.9"
  // , "org.scala-lang" % "scala-reflect" % "2.12.3"
  , "net.liftweb" % "lift-webkit_2.12" % "3.2.0"
  , "io.spray" %% "spray-json" % "1.3.4"
  , "com.typesafe.play" % "play-ahc-ws-standalone_2.12" % "1.1.3"
  , "org.slf4j" % "slf4j-simple" % "1.7.25"
)

scalacOptions += "-deprecation"
