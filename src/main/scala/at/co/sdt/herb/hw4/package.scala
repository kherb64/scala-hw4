/**
  * my first package object
  */
package object hw4 {

  /**
    * print package object's name
    */
  def po(): Unit = {
    println(s"package object ${ this.getClass } is here")
  }
}
