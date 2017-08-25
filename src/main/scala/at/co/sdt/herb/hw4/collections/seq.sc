case class Person(name: String)

val myFriends = Seq(
  Person("Adam"),
  Person("David"),
  Person("Frank")
)

val adamsFriends = Seq(
  Person("Nick"),
  Person("David"),
  Person("Frank")
)

val mutualFriends = for {
  myFriend <- myFriends // generator
  adamsFriend <- adamsFriends // generator
  if myFriend.name == adamsFriend.name
} yield myFriend

mutualFriends.foreach(println)
