class BindingSpec extends UnitSpec {

  "Tests" should "be working" in {
    true shouldBe true
  }

  val resultMap = List(1, 2, 3, 4, 5)
  "map" should s"return ${ resultMap.length } entries" in {
    Binding.map.length shouldBe resultMap.length
  }

  it should s"return $resultMap" in {
    Binding.flatMap == resultMap
  }

  val resultFlatMap = List(1, 3)
  "flatMap" should s"return ${ resultFlatMap.length } entries" in {
    Binding.flatMap.length shouldBe resultFlatMap.length
  }

  it should s"return $resultFlatMap" in {
    Binding.flatMap == resultFlatMap
  }

  "yieldi" should s"return  ${ resultMap.length } entries " in {
    Binding.`yield`.length shouldBe resultMap.length
  }

  it should s"return $resultMap" in {
    Binding.flatMap == resultMap
  }

  //"14.7.1581" should "throw an illegal argument exception" in {
  //  assertThrows[IllegalArgumentException](new Date(1581, 7, 14))
}
