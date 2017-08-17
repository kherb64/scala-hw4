package at.co.sdt.herb.hw4

case class Postcard(msg: String)

object Postcard {
  def sendPostcards: List[Postcard] = {
    val states = List("Arizona", "New Mexico",
      "Texas", "Louisiana",
      "Mississippi", "Virginia",
      "New York", "Ohio",
      "Illinois")
    val relatives = List("Grandma", "Grandpa", "Aunt Dottie", "Dad")
    val travellers = List("Kelsey", "DJ")

    for {
      traveller <- travellers
      sender = traveller + " (your favorite)"
      relative <- relatives
      theState <- states
      if relative.startsWith("G")
    } yield {
      new Postcard("Dear " + relative + ", " +
        "Wish you were here in " +
        theState + "! " +
        "Love, " + sender)
    }
  }


  def main(args: Array[String]) {
    println(Postcard.sendPostcards)
  }
}