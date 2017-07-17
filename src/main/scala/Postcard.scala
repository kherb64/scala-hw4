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

    var postcardList: List[Postcard] = List()

    for (h <- travellers.indices) {
      val sender = travellers(h)

      for (i <- relatives.indices) {
        val recipient = relatives(i)

        for (j <- states.indices) {
          val theState = states(j)
          postcardList ::=
            new Postcard("Dear " + recipient + ", " +
              "Wish you were here in " +
              theState + "! " +
              "Love, " + sender)
        }
      }
    }

    postcardList
  }


  def main(args: Array[String]) {
    println(Postcard.sendPostcards)
  }
}