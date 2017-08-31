package at.co.sdt.herb.hw4.serialization

import java.io.{ FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream }

import at.co.sdt.herb.hw4
import at.co.sdt.herb.hw4.File

import scala.util.Random

case class Stock(symbol: String, var price: BigDecimal) extends Serializable {
}

object SerializationDemo extends App {
  val r = Random
  val nflx = {
    Stock("NFLX", BigDecimal((r.nextDouble * 10000.0).round / 100.0))
  }
  println(nflx)

  val filename = hw4.resourcesDir + "/nflx.dat"

  // save to file
  for (file <- File.ofName(filename)) {
    val oos = new ObjectOutputStream(new FileOutputStream(file))
    oos.writeObject(nflx)
    oos.close()
    println(s"${ file.getCanonicalPath } written (${ file.length() } Bytes)")
  }

  // create from file
  for (file <- File.ofName(filename)) {
    val ois = new ObjectInputStream(new FileInputStream(file))
    val stock = ois.readObject().asInstanceOf[Stock]
    ois.close()
    println(stock)

    // compare
    println(nflx == stock)
  }

}
