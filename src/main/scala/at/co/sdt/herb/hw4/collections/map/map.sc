

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

mStates.retain((k, _) => k < "B")

n3.filterKeys(_ > "B")
n3.filterKeys(_ < "B")
n3.filterKeys(_ == "AL")

for {
  (k, v) <- n3
  if k.toUpperCase.startsWith("A")
} println(s"$k -> $v")

for (t <- n3) {
  println(s"$t")
  val i = t.productIterator
  i.foreach(println)
}

n3.foreach(t => println(t))

n3.contains("FOO")
n3.contains("A")

n3.keysIterator.foreach(println)
n3.valuesIterator.foreach(println)
n3.keys.foreach(println)
n3.values.foreach(println)

n3.transform((k, v) => s"$v (${ k.length })")
n3.transform((k, _) => k.length)
// n3.transform(t: Tuple2[String, String] => s" $(t._1) ( $(t._2))")
