package connectors

import com.google.inject.{ImplementedBy, Inject, Singleton}
import play.api.http.Status
import play.api.libs.json.{Format, Json}
import play.mvc.Http.Status.INTERNAL_SERVER_ERROR
import config.AppConfig
import utils.HttpResponse
import models._
import io.shaka.http.Http.http
import io.shaka.http.Request.{GET, POST}
import io.shaka.http.Response

import scala.concurrent.{ExecutionContext, Future}

@ImplementedBy(classOf[ProductDBConnectorImpl])
trait ProductDBConnector {

  def getProducts(): Response
}

@Singleton
class ProductDBConnectorImpl @Inject() ()(implicit appConfig: AppConfig) {

  val getProductsBaseURL: String = appConfig.baseUrl("get-products")

  override def getProducts(): Response =
    http(GET(s"$getProductsBaseURL/get-products"))
//    .recover {
//      case e =>
//        logger.warn(s"unexpected error from ProductDB during /get-products, message=${e.getMessage}")
//
//        val errorJson = ErrorResponse("error from ProductDB during /get-products", s"${e.getMessage}").toJson()
//        HttpResponse(INTERNAL_SERVER_ERROR, responseJson = Some(errorJson))
//    }
}