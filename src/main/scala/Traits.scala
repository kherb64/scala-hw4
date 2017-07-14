
trait Ord {
  def <(that: Any): Boolean

  def >(that: Any): Boolean = !(this <= that)

  def <=(that: Any): Boolean = (this < that) || (this == that)

  def >=(that: Any): Boolean = !(this < that)
}

class Date(y: Int, m: Int, d: Int) extends Ord {

  // basic requirements
  require(y >= 1582)
  require(m >= 1 && m <= 12)
  require(d >= 1 && d <= 31)

  // TODO: real date requirement
  java.time.LocalDate.of(y, m, d)
  if (y <= 1582) println("Warning, historical dates may be wrong.")

  override def toString: String = year + "-" + month + "-" + day

  override def equals(that: Any): Boolean =
    that.isInstanceOf[Date] && {
      val o = that.asInstanceOf[Date]
      o.day == day && o.month == month && o.year == year
    }

  override def <(that: Any): Boolean = {
    if (!that.isInstanceOf[Date])
      sys.error("cannot compare " + that + " and a Date")
    val o = that.asInstanceOf[Date]
    (year < o.year) ||
      (year == o.year && (month < o.month ||
        (month == o.month && day < o.day)))
  }

  def year: Int = y

  def month: Int = m

  def day: Int = d
}

object Date {
  def main(args: Array[String]) {
    println(new Date(2001, 1, 1))
    println(new Date(2002, 2, 28))
  }
}
