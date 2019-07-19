//package models
//
//case class UserId(value: String) extends AnyVal
//
//case class Token(value: String) extends AnyVal
//
//case class HeaderCarrier(
//                          authorization: Option[Authorization]       = None,
//                          userId: Option[UserId]                     = None,
//                          token: Option[Token]                       = None,
//                          forwarded: Option[ForwardedFor]            = None,
//                          sessionId: Option[SessionId]               = None,
//                          requestId: Option[RequestId]               = None,
//                          requestChain: RequestChain                 = RequestChain.init,
//                          nsStamp: Long                              = System.nanoTime(),
//                          extraHeaders: Seq[(String, String)]        = Seq(),
//                          trueClientIp: Option[String]               = None,
//                          trueClientPort: Option[String]             = None,
//                          gaToken: Option[String]                    = None,
//                          gaUserId: Option[String]                   = None,
//                          deviceID: Option[String]                   = None,
//                          akamaiReputation: Option[AkamaiReputation] = None,
//                          otherHeaders: Seq[(String, String)]        = Seq())