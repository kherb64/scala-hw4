package at.co.sdt.herb.hw4

/**
  * Created by herb on 11.10.2016.
  * Conclusion: do not use user defined value classes at an early stage of knowledge!
  */

class Hurzi /* extends Int */ {
  def unary_~ : Int = { -1 }
  def == : Boolean = { true }
  def toDouble: Double = { 1.0d }
  def == (b:Byte): Boolean = { true }
}
