object Buchstabensalat {
  // val original = "Birgit Stegsund Eutin"
  val original = "coknle"
  // val original3 = List[Char]('b', 'r', 'l', 'l', 'i', 'e').toString()

  def main(args: Array[String]) {
    // println(pick(original, 1))
    val r: Array[String] = result(original)
    for (myString <- r) {
      println(myString)
    }
    println(original.length + " Zeichen ergeben gefiltert " + r.length + " permutations")
  }

  def pick(string: String, position: Int): Array[String] = {
    val iterated: Array[String] = new Array[String](string.length())
    iterated(1) = string
    iterated
  }

  def consonantAfter(text: String, pattern: String): Boolean = {
    true
  }

  def aussieben(text: String): Boolean = {
    val list: List[Char] = text.toCharArray.toList
    list match {
      case _ :: 'i' :: 'i' :: 'i' :: _ => false
      case _ :: 't' :: 't' :: 't' :: _ => false
      case _ :: 'u' :: 'u' :: _ => false
      /* case s => {
        val i = s.indexOfSlice("ii")
        if (i > 0) consonantAfter(s, "ii")

        else
        val i = s.indexOfSlice("ee")
        if (i > 0) consonantAfter(s, "ee")

        case s
        if s.contains("gg")
        => consonantAfter(s, "")
        case s
        if s.contains("tt")
        => vowelAfter(s, "")
        case s
        if s.contains("nn")
        => consonantAfter(s, "")
        case s
        if s.contains("ss")
        => vowelBefore(s, "")
      } */
    case _ => true
    }
  }

  def isConsonant(c: Char): Boolean = {
    "bcdfghjklmnpqrstvwxyz" contains c
  }

  def isVowel(c: Char): Boolean = {
    "aeiou" contains c
  }

  def result(text: String): Array[String] = {
    text.permutations.filter(aussieben).toArray
    //text.combinations(2).toArray
    //text.flatten.combinations(2).toArray
  }


  /**
    * Created by herb on 13.02.2017.
    */
  class Buchstabensalat {
  }

}
