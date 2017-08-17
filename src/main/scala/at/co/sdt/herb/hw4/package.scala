package at.co.sdt.herb.hw4

/**
  * my first package object
  */
package object po {

  /**
    * print package object's name
    */
  def po(): Unit = {
    println(s"package object ${ this.getClass } is here")
  }
}
