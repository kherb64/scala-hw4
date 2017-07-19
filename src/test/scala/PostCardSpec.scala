/**
  * Created by herb on 17.07.2017.
  */
class PostCardSpec extends UnitSpec {

  "Tests" should "be working" in {
    true shouldBe true
  }

  val numPostCards = 36 // with filter
  "Postcardslist" should s"have $numPostCards entries" in {
    Postcard.sendPostcards.length shouldBe numPostCards
  }

  //"14.7.1581" should "throw an illegal argument exception" in {
  //  assertThrows[IllegalArgumentException](new Date(1581, 7, 14))
}
