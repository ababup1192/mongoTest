name := "mongo"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "se.radley" %% "play-plugins-salat" % "1.4.0",
  cache
)

play.Project.playScalaSettings

routesImport += "se.radley.plugin.salat.Binders._"

templatesImport += "org.bson.types.ObjectId"