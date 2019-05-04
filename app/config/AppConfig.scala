package config

import configs.syntax._
import com.google.inject.Singleton
import javax.inject.Inject
import play.api.Mode.Mode
import play.api._
import play.api.{Configuration, Environment}

@Singleton
class AppConfig @Inject() (override val runModeConfiguration: Configuration) {

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
      .getOrElse(
        runModeConfiguration
          .getString(s"$services.$confKey")
          .getOrElse(runModeConfiguration.getString(s"$playServices.$confKey").getOrElse(defString)))

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