val x = List.range(1, 10)

//val evens =
x.filterNot(_ % 2 == 0)

val list = "apple" :: "banana" :: 1 :: 2 :: Nil
//val strings =
list.filter {
  case _: String => true
  case _ => false
}

list.collect {
  case s: String => s
}
