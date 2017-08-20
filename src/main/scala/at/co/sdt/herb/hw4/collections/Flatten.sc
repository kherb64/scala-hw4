val couples = List(List("kim", "al"), List("julia", "terry"))

val people = couples.flatten

val myFriends = List("Adam", "David", "Frank")
val adamsFriends = List("Nick K", "Bill M")
val davidsFriends = List("Becca G", "Kenny D", "Bill M")
val friendsOfFriends = List(adamsFriends, davidsFriends)

val uniqueFriendsOfFriends = friendsOfFriends.flatten.distinct

val x = Vector(Some(1), None, Some(3), None)
x.flatten

val b: Option[String] = Some("burli")
val n: Option[String] = None
/* cannot go
b.flatten
n.flatten */

val bag = List("1", "2", "three", "4", "one hundred seventy five")

def toInt(in: String): Option[Int] = {
  try {
    Some(Integer.parseInt(in.trim))
  } catch {
    case _: Exception => None
  }
}

bag.flatMap(toInt).sum
