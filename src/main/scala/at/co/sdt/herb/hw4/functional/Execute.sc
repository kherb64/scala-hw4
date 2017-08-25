// package at.co.sdt.herb.hw4.functional

def executeFunction(callback: () => Unit): Unit = {
  callback()
}

val sayHello = () => { println("Hello") }
executeFunction(sayHello)

def executeFunction1(i: Int)(f: (Int) => Int): Int = {
  f(i)
}

def executeFunction2(f: (Int, Int) => Int, i: Int, j: Int): Int = {
  f(i, j)
}

val plus1 = (i: Int) => { i + 1 }
val plus10 = (i: Int) => { i + 10 }
executeFunction1(2)(plus1)
executeFunction1(3)(plus10)
executeFunction1(4) { (i: Int) => { i + 4 } }

def executePlus1(i: Int): Int = { executeFunction1(i)(plus1) }
executePlus1(4)

// two Integers
val addTwoInts = (i: Int, j: Int) => { i + j }
val multiplyTwoInts = (i: Int, j: Int) => { i * j }
executeFunction2(addTwoInts, 1, 2)
executeFunction2(multiplyTwoInts, 2, 3)

val plus2 = (i: Int) => { addTwoInts(i, 2) }
plus2(6)

val times3 = (i: Int) => { multiplyTwoInts(i, 3) }
times3(7)

// function generator
def plusser(i: Int): (Int) => Int = {
  (j: Int) => { addTwoInts(i, j) }
}
val plus3 = plusser(3)
plus3(3)

plusser(15).apply(23)
plusser(15)(23)
