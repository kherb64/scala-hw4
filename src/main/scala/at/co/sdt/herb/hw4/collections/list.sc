import java.io

1 :: 2 :: 3 :: Nil

List(2, 3, 4)

List.range(1, 10)

List.fill(3)("hurzi")

List.tabulate(5)(_ * 3)
List.tabulate(2, 2)(_ * 10 + _)
List.iterate(1, 10)(_ * 2)

import scala.collection.mutable

var fruits = new mutable.ListBuffer[String]()
fruits += "apple"
fruits += "orange"
fruits += "banana"
fruits += ("grapes", "kiwi", "elseberry")

fruits -= "apple"
fruits -= "apple"

"burli" :: fruits.toList

val ll: List[String] = fruits.toList ::: "bertl" :: Nil
