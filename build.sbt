
name := "hw4"

version := "1.15.0-SNAPSHOT"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test"
  , "org.scala-lang.modules" % "scala-xml_2.12" % "1.0.6"
  , "com.typesafe.akka" % "akka-actor_2.12" % "2.5.4"
  // , "org.scala-lang" % "scala-reflect" % "2.12.3"
)
