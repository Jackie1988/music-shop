package repos

//import cats.data.EitherT
import com.google.inject.{ImplementedBy, Inject, Singleton}
//import models.{HeaderCarrier, MusicProduct}
import config.MongoConfig._

//@ImplementedBy(classOf[MongoDrumKitRepo])
//trait DrumKitRepo {
//
//  def getAll()(implicit hc: HeaderCarrier): EitherT[Future, String, List[Product]]
//}

@Singleton
class MongoDrumKitRepo @Inject() () {

//  def getAll()(implicit hc: HeaderCarrier): EitherT[Future, String, List[Product]] = {
//
//  }

//  // Write Documents: insert or update
//  implicit def productWriter: BSONDocumentWriter[MusicProduct] = Macros.writer[MusicProduct]
//  // or provide a custom one
//
//  // use productWriter
//  def createProduct(product: MusicProduct): Future[Unit] =
//    musicStoreCollection.flatMap(_.insert.one(product).map(_ => {}))
//
//  def updateProduct(product: MusicProduct): Future[Int] = {
//    val selector = document(
//      "id" -> product.id,
//      "name" -> product.name,
//      "description" -> product.description,
//      "price" -> product.price,
//      "stockCount" -> product.stockCount
//    )
//
//    // Update the matching product
//    musicStoreCollection.flatMap(_.update.one(selector, product).map(_.n))
//  }
//
//  implicit def productReader: BSONDocumentReader[MusicProduct] = Macros.reader[MusicProduct]
//  // or provide a custom one
//
//  def findProductById(id: String): Future[List[MusicProduct]] =
//    musicStoreCollection.flatMap(_.find(document("id" -> id)). // query builder
//      cursor[MusicProduct](). // using the result cursor
//      collect[List](-1, Cursor.FailOnError[List[MusicProduct]]()))
//  // ... deserializes the document using personReader
}