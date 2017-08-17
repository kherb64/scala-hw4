import java.io.{ FileInputStream, FileOutputStream }

val names = Array("chris", "ed", "maurice")

for (e <- names) yield e.capitalize
for (e <- names) yield e.length

names map (_.capitalize)
names map (_.length)

val numberWord = Map(1 -> "eins")

numberWord.getOrElse(1, "")
numberWord.getOrElse(2, "")

var in = None: Option[FileInputStream]

var in2: Option[FileInputStream] = None
