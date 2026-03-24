lazy val root = (project in file("."))
  .settings(
    name := "rabbitmq-scala-devcontainer",
    scalaVersion := "3.8.2",
    libraryDependencies += "org.scalameta" %% "munit" % "1.2.4" % Test
  )
