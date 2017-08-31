package at.co.sdt.herb.hw4.files_and_processes

object BinaryFiles extends App {

  import at.co.sdt.herb.hw4

  val srcFile = hw4.resourcesDir + "/BinaryFiles.class"
  new BinaryFiles(srcFile).copyBytes(srcFile + ".copy")
  new BinaryFiles(srcFile).copyBytes2(srcFile + ".copy2")
}

class BinaryFiles(sourceFileName: String) {

  import java.io.{ FileInputStream, FileNotFoundException, FileOutputStream, IOException, File => JFile }

  val sourceFile = new JFile(sourceFileName)

  def copyBytes(targetFileName: String): Unit = {
    val targetFile = new JFile(targetFileName)

    var in = None: Option[FileInputStream]
    var out = None: Option[FileOutputStream]
    try {
      in = Some(new FileInputStream(sourceFile))
      out = Some(new FileOutputStream(targetFile))
      var c = 0
      while ( {
        c = in.get.read
        c != -1
      }) {
        out.get.write(c)
      }
    } catch {
      case e: IOException => println(e)
      case e: FileNotFoundException => println(e)
    } finally {
      println("closing files")
      if (in.isDefined) in.get.close()
      if (out.isDefined) {
        println(s"${ targetFile.getCanonicalFile } written")
        out.get.close()
      }
    }
  }


  def copyBytes2(targetFileName: String): Unit = {

    import java.io.{ FileInputStream, FileOutputStream, File => JFile }
    val targetFile = new JFile(targetFileName)

    try {
      val inStream = Some(new FileInputStream(sourceFile))
      val outStream = Some(new FileOutputStream(targetFile))
      try {
        for (in <- inStream; out <- outStream) {
          var c = 0
          while ( {
            c = in.read
            c != -1
          }) {
            out.write(c)
          }
        }
      } catch {
        case e: IOException => println(e)
      }
      finally {
        if (inStream.isDefined) inStream.get.close()
        if (outStream.isDefined) {
          println(s"${ targetFile.getCanonicalFile } written")
          outStream.get.close()
        }
      }
    } catch {
      case e: FileNotFoundException => println(e)
      case e: IOException => println(e)
    }

  }
}