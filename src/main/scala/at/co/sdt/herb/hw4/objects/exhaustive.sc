sealed trait Message {def msg: String }

case class Success(msg: String) extends Message

case class Failure(msg: String) extends Message

def log(msg: Message): Unit = msg match {
  case Success(str) => println("Success: " + str)
  case Failure(str) => println("Failure: " + str)
}

