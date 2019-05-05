package config

import com.google.inject.Singleton
import javax.inject.Inject
import play.api.Mode.Mode
import play.api._
import play.api.{Configuration, Environment}

@Singleton
class AppConfig @Inject() (override val runModeConfiguration: Configuration) {

  protected lazy val rootServices = "microservice.services"
  //protected lazy val services     = s"$env.microservice.services"

  protected lazy val defaultProtocol: String =
    runModeConfiguration
      .getString(s"$rootServices.protocol")
      .getOrElse("http")

  def baseUrl(serviceName: String) = {
    val protocol = getConfString(s"$serviceName.protocol", defaultProtocol)
    val host =
      getConfString(s"$serviceName.host", throw new RuntimeException(s"Could not find config $serviceName.host"))
    val port = getConfInt(s"$serviceName.port", throw new RuntimeException(s"Could not find config $serviceName.port"))
    s"$protocol://$host:$port"
  }

  def getConfString(confKey: String, defString: => String) =
    runModeConfiguration
      .getString(s"$rootServices.$confKey")

  def getConfInt(confKey: String, defInt: => Int) =
    runModeConfiguration
      .getInt(s"$rootServices.$confKey")
}

trait RunMode {
  protected def mode: Mode
  protected def runModeConfiguration: Configuration
}

object RunMode {
  def apply(runMode: Mode, configuration: Configuration): RunMode =
    new RunMode {
      override protected def mode: Mode = runMode

      override protected def runModeConfiguration: Configuration = configuration
    }
}