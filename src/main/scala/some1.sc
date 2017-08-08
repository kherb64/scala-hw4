val numPattern = "[0-9]+".r


val r = new scala.util.Random(java.util.Calendar.getInstance().getTimeInMillis)
val b = Array.ofDim[Byte](3)
r.nextBytes(b)
b
val c = Array.fill(3) { r.nextInt(256) }


def addNaturals(nats: List[Int]): Int = {
  require(nats forall (_ >= 0), "List contains negative numbers")
  // nats.foldLeft(0)(_ + _)
  nats.sum
} ensuring (_ >= 0)
def addNaturals2(nats: List[Int]): Int = {
  assert(nats forall (_ >= 0), "List contains negative numbers")
  nats.sum
} ensuring (_ >= 0)
/* addNaturals1(List(-1,2,3))
addNaturals2(List(-1,2,3)) */


val l1 = Seq[String]("hurzi1", "hurzi2")
val l2 = Seq[String]()
def first[A](s: Seq[A]) : Option[A] = {
  s.headOption
}
first(l1)
first(l2)


import scala.language.postfixOps
class name {
  def toList:List[String] = List[String]("c", "d")
}
val names = new name
names toList
