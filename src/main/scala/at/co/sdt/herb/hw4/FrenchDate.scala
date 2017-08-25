package at.co.sdt.herb.hw4

/**
  * Created by herb on 09.10.16.
  */

import java.text.DateFormat._
import java.util.Locale

object FrenchDate {
  def main(args: Array[String]) {
    val now = new java.util.Date
    val df = getDateInstance(LONG, Locale.FRANCE)
    println(df format now)
  }
}

