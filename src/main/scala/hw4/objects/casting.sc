
/**
  * My try of missing definition. Compiles, but not working.
  */
case class Recognizer()

case class Microphone()

class ConfigurationManager(file: String) {
  def lookup(str: String): AnyRef = str match {
    case "recognizer" => Recognizer.getClass.getComponentType
    case "microphone" => Microphone.getClass.getComponentType
  }
}

val cm = new ConfigurationManager("config.xml")
// instance of Recognizer
val recognizer = cm.lookup("recognizer").asInstanceOf[Recognizer]
// instance of Microphone
val microphone = cm.lookup("microphone").asInstanceOf[Microphone]