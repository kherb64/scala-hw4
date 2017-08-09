package hw4.classes

import hw4.UnitSpec

class PersonSpec extends UnitSpec {

  "Tests" should "be working" in {
    true shouldBe true
  }

  val first = "Herbert"
  val last = "Kreutzer"
  val p = new Person(first, last)
  s"Person($first, $last)" should "not be null" in {
    p should not be null
  }

  "it" should "be an instance of Person" in {
    p.isInstanceOf[Person] shouldBe true
  }

  "it" should "be 0 years old" in {
    p.age shouldBe 0
  }

  "it" should s"read $first $last is 0 years old" in {
    p.toString shouldBe s"$first $last is 0 years old"
  }

  val newAge = 53
  "it" should s"be $newAge years old when age set to $newAge" in {
    p.age = newAge
    p.age shouldBe newAge
  }

  val newFirst = "Bertl"
  "it" should s"read $newFirst $last is $newAge years old when first name is changed to $newFirst" in {
    p.firstName = newFirst
    p.toString shouldBe s"$newFirst $last is $newAge years old"
  }

  val newLast = "Bua"
  "it" should s"read $newFirst $newLast is $newAge years old when last name is changed to $newLast" in {
    p.lastName = newLast
    p.toString shouldBe s"$newFirst $newLast is $newAge years old"
  }
}
