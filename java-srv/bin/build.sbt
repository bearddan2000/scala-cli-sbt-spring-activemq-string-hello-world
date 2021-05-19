lazy val root = (project in file("."))
  .settings(
    name := "spring-boot-scala-web",

    version := "1.0",

    scalaVersion := "2.10.4",

    libraryDependencies ++= Seq(
      "org.springframework.boot" % "spring-boot-starter-activemq" % "2.4.2"
     ),

    mainClass := Some("example.MyApp")
)
