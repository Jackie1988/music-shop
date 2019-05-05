package controllers

import com.google.inject.Inject
import play.api.mvc._
import connectors.ProductDBConnector

import scala.concurrent.ExecutionContext

 class MusicShopController @Inject() (productDBConnector: ProductDBConnector) extends BaseController {

  def getProducts: Action[AnyContent] = Action { implicit request ⇒
    productDBConnector.getProducts
  }

}