package hw4.numbers

import hw4.UnitSpec
import java.time.LocalDateTime
import Numbers._

class NumbersSpec extends UnitSpec {

  "Tests" should "be working" in {
    true shouldBe true
  }

  private val i = 246
  "toInt()" should s"return $i for $i" in {
    toInt(i.toString) shouldBe Some(i)
  }
  private val ia = Array[Option[Int]](Some(-2), Some(-1), Some(0), Some(1), Some(2))
  private val ca = Array[String]("-2", "-1", "0", "1", "2")
  "toInt()" should s"return $ia for $ca" in {
    ca.map(toInt) shouldBe ia
  }

  private val c = "Herb"
  it should s"return None for $c" in {
    toInt(c) shouldBe None
  }

  private val d = 1.2
  it should s"return None for $d" in {
    toInt(d.toString) shouldBe None
  }

  private val l = LocalDateTime.now()
  it should s"return None for $l" in {
    toInt(l.toString) shouldBe None
  }
}
