package controllers

import com.google.inject.Inject

import play.api.mvc._
import scala.concurrent.ExecutionContext
import scala.concurrent.duration.Duration
import scala.concurrent.Await
import connectors.{MusicProductDBConnector, PersonDBConnector}
import connectors.Person
import models.MusicProduct

 class MusicShopController @Inject() (productDBConnector: MusicProductDBConnector,
                                      personDBConnector: PersonDBConnector,
                                      cc: ControllerComponents) extends AbstractController(cc) {

//  def getProducts: Action[AnyContent] = Action { implicit request ⇒
//    productDBConnector.getProducts
//  }

   def addProduct: Action[AnyContent] = Action { implicit request ⇒
//     val result = productDBConnector.createPerson(Person("James", "Smith", 27))
//     Await.result(result, Duration.Inf)

//     personDBConnector.createPerson(Person("Teddy", "Jones", 48))
//     personDBConnector.createPerson(Person("Michael", "Jones", 48))
//     personDBConnector.createPerson(Person("Roger", "Jones", 48))
//     personDBConnector.createPerson(Person("Timothy", "Jones", 48))

     productDBConnector.addProduct(MusicProduct("003", "Roland electronic drum kit mega", "electronic drum kit", "560.00", 6))
     productDBConnector.addProduct(MusicProduct("004", "Saxophone", "a sax", "785.00", 3))


     Ok("Music products were added to the music-shop database")
   }

}