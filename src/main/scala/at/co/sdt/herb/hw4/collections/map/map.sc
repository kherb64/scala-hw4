
val states = Map("AL" -> "Alabama", "AK" -> "Alaska")

import scala.collection.mutable

var mStates = mutable.Map[String, String]("AL" -> "Alabama")
mStates += "AK" -> "Alaska"
val t = ("Bertl", "Bua")
mStates += t
mStates += (("New", "Tuple"))

val names = Map("A" -> "Anneliese")
val n2 = names + ("B" -> "Bertl")

val n3 = names ++ mStates

mStates("AL")
names("A")

n2.keys.mkString(",")
n3.values.mkString(",")

val n4 = mStates.mapValues(_.toUpperCase)
val n5: collection.Map[String, Int] = mStates.mapValues((v) => v.length)
//val n6:collection.Map[String,Int] = mStates.transform((k, v) => v.length)

n3.filterKeys(_ > "B")
n3.filterKeys(_ < "B")
n3.filterKeys(_ == "AL")
