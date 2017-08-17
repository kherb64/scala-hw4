import scala.collection.mutable.ArrayBuffer

val fruits = ArrayBuffer("apple")
// the function addToBasket has a reference to fruits
val addToBasket = (s: String) => {
  fruits += s
  println(fruits.mkString(", "))
}

def buyStuff(f: String => Unit, s: String) {
  f(s)
}

buyStuff(addToBasket, "cherries")
buyStuff(addToBasket, "grapes")