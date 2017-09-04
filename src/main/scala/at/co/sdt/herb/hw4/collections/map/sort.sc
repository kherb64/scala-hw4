val grades = Map("Kim" -> 90,
  "Al" -> 85,
  "Melissa" -> 95,
  "Emily" -> 91,
  "Hannah" -> 92
)

grades.toSeq.sortBy(t => t._2)
grades.toSeq.sortBy(t => t._1)

grades.toSeq.sortBy(t => t._1)
grades.toSeq.sortBy(t => t._2)

grades.keys.toSeq.sortBy((s) => s)
grades.values.toSeq.sortBy((s) => s)

// TODO: warum muss ich hier beim Tuple2 mit case eine partial function machen?
grades.toSeq.sortBy({ case (k, _) => k })
grades.toSeq.sortBy({ case (_, v) => v })

collection.immutable.ListMap("Kim" -> 90,
  "Al" -> 85,
  "Melissa" -> 95,
  "Emily" -> 91,
  "Hannah" -> 92)
collection.immutable.ListMap(grades.toSeq.sortWith(_._1 < _._1): _*)
collection.immutable.ListMap(grades.toSeq.sortBy({ case (_, v) => v }): _*)

val grades2 = Map("Al" -> 80, "Kim" -> 95, "Teri" -> 85, "Julia" -> 90)
// max
grades2.max