/**
  * Created by herb on 14.07.2017.
  */
class Reference[T] {
  private var contents: T = _

  def set(value: T) { contents = value }

  def get: T = contents
}

case class MyType(n: String, v:String) {
  override def toString: String = n + "=" + v
  def reverse:String = v + "=" + n
}

object IntegerReference {
  def main(args: Array[String]) {
    val cell = new Reference[Int]
    cell.set(13)
    println("Reference contains the half of " + (cell.get * 2))
  }
}

object MyTypeReference {
  def main(args: Array[String]): Unit = {
    val cell = new Reference[MyType]
    cell.set(MyType("k", "h"))
    println("Reference contains " + (cell.get))
    println("Reference reverses " + (cell.get.reverse))
  }
}
