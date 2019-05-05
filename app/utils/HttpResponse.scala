package utils

import play.api.libs.json.{JsValue, Json}

// not my code
trait HttpResponse {
  def allHeaders: Map[String, Seq[String]] = ???

  def header(key: String): Option[String] = allHeaders.get(key).flatMap { list =>
    list.headOption
  }

  def status: Int = ???

  def json: JsValue = ???

  def body: String = ???
}

object HttpResponse {
  def apply(
             responseStatus: Int,
             responseJson: Option[JsValue]             = None,
             responseHeaders: Map[String, Seq[String]] = Map.empty,
             responseString: Option[String]            = None) = new HttpResponse {
    override def allHeaders: Map[String, Seq[String]] = responseHeaders
    override def body: String                         = responseString orElse responseJson.map(Json.prettyPrint) orNull
    override def json: JsValue                        = responseJson.orNull
    override def status: Int                          = responseStatus
  }

  def unapply(that: HttpResponse) = Some((that.status, that.json, that.allHeaders, that.body))
}
