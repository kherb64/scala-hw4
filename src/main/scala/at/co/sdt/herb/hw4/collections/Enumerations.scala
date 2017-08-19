package at.co.sdt.herb.hw4.collections

package enumerations {

  object Margin extends Enumeration {
    type Margin = Value
    val Top, Bottom, Left, Right = Value

    Margin.values foreach println
  }

}

object MarginMain extends App {
  enumerations.Margin
}


