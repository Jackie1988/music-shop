package connectors

import scala.concurrent.{ ExecutionContext, Future }

import reactivemongo.api.{ Cursor, DefaultDB, MongoConnection, MongoDriver }
import reactivemongo.bson.{BSONDocumentWriter, BSONDocumentReader, Macros, document}
import models.MusicProduct

class MusicProductDBConnector {
  // My settings (see available connection options)
  val mongoUri = "mongodb://localhost:27017/mydb?authMode=scram-sha1"

  import ExecutionContext.Implicits.global // use any appropriate context

  // Connect to the database: Must be done only once per application
  val driver = MongoDriver()
  val parsedUri = MongoConnection.parseURI(mongoUri)
  val connection = parsedUri.map(driver.connection(_))

  // Database and collections: Get references
  val futureConnection = Future.fromTry(connection)
  def musicDB: Future[DefaultDB] = futureConnection.flatMap(_.database("music-shop"))
  def musicProductCollection = musicDB.map(_.collection("products"))

  // Write Documents: insert or update
  implicit def productWriter: BSONDocumentWriter[MusicProduct] = Macros.writer[MusicProduct]
  // or provide a custom one

  // use personWriter
  def addProduct(product: MusicProduct): Future[Unit] =
    musicProductCollection.flatMap(_.insert.one(product).map(_ => {}))
}