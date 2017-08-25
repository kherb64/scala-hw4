trait Human {
  def hello = "the Human trait"
}

trait Mother extends Human {
  override def hello = "Mother"
}

trait Father extends Human {
  override def hello = "Father"
}

class Child extends Human with Mother with Father {
  def printSuper = super.hello

  def printMother = super[Mother].hello

  def printFather = super[Father].hello

  def printHuman = super[Human].hello
}

val c = new Child
c.printSuper
c.printMother
c.printFather
c.printHuman
