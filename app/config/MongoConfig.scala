package config

import scala.concurrent.{ ExecutionContext, Future }

import reactivemongo.api.{ Cursor, DefaultDB, MongoConnection, MongoDriver }

object MongoConfig {
  // My settings (see available connection options)
  val mongoUri = "mongodb://localhost:27017/music-store"

  import ExecutionContext.Implicits.global // use any appropriate context

  // Connect to the database: Must be done only once per application
  val driver = MongoDriver()
  val parsedUri = MongoConnection.parseURI(mongoUri)
  val connection = parsedUri.map(driver.connection(_))

  // Database and collections: Get references
  val futureConnection = Future.fromTry(connection)
  def db1: Future[DefaultDB] = futureConnection.flatMap(_.database("music-store"))
  def musicStoreCollection = db1.map(_.collection("products"))

}