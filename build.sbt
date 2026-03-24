lazy val root = (project in file("."))
  .settings(
    name := "rabbitmq-scala-devcontainer",
    scalaVersion := "3.8.2",
    libraryDependencies ++= Seq(
      "com.rabbitmq" % "amqp-client" % "5.29.0",
      "org.scalameta" %% "munit" % "1.2.4" % Test
    )
  )
