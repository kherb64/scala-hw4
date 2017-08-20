List(10, 5, 8, 1, 7).sorted

List(10, 5, 8, 1, 8, 7).sortWith(_ >= 2 * _)

List("Ulli", "Herbert", "Bertl", "Freddy", "Burli").
  sortWith(_.length < _.length)

object Person {
  var sortByFirst = true

  def apply(first: String, last: String) = new Person(first, last)
}

class Person(fName: String, lName: String) extends Ordered[Person] {
  val first: String = fName
  val last: String = lName

  override def compare(that: Person): Int = {

    def oldButGold(s1: String, s2: String, s3: String = "", s4: String = ""): Int = {
      if (s1 == "" && s2 == "") 0
      else if (s1 == s2) oldButGold(s3, s4)
      else if (s1 > s2) 1
      else -1
    }

    def cTwoPairs(s1: String, s2: String, s3: String = "", s4: String = ""): Int = {
      var c = s1 compare s2
      if (c == 0) c = s3 compare s4
      c
    }

    if (Person.sortByFirst) cTwoPairs(this.first, that.first, this.last, that.last)
    else cTwoPairs(this.last, that.last, this.first, that.first)
  }

  override def toString: String = if (Person.sortByFirst) s"$first $last"
  else s"$last $first"
}

val family = List(
  Person("Ulli", "K"),
  Person("Freddy", "K"),
  Person("Bertl", "K"),
  Person("Herbert", "K"),
  Person("Anneliese", "F"),
  Person("Otto", "F")
)

family.sorted
Person.sortByFirst = false
family.sorted

family(5) > family(1)
