package models

import play.api.libs.json.{Format, Json}

case class MusicProduct(id: String, name: String, description: String, price: String, stockCount: Int)

object MusicProduct {
  implicit val productFormat: Format[MusicProduct] = Json.format[MusicProduct]
}
