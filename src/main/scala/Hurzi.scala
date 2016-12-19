/**
  * Created by herb on 11.10.2016.
  * Conclusion: do not use user defined value classes at an early stage of knowledge!
  */

class Hurzi /* extends Int */ {
  def unary_~ = { -1 }
  def == = { true }
  def toDouble = { 1.0d }
  def == (b:Byte) = { true }
}
