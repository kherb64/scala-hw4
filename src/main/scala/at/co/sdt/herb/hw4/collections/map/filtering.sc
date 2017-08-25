val weekdays = Map(
  0 -> "Sunday",
  1 -> "Monday",
  2 -> "Tuesday",
  3 -> "Wednesday",
  4 -> "Thursday",
  5 -> "Friday",
  6 -> "Saturday"
)

val isWorkDay = (d: Int) => d >= 1 && d <= 5
val weekendDays1 = weekdays.filterKeys((d) => !isWorkDay(d))
val weekendDays2 = weekdays.filterKeys(!isWorkDay(_))

// following line do not compile, because
// val weekendDays3 = weekdays.filterKeys(!isWorkDay _ )
// val weekendDays4 = weekdays.filterKeys(!isWorkDay)

val workDays = weekdays.filterKeys(isWorkDay)

def predicateInverter[T](p: (T) => Boolean): (T) => Boolean = {
  // look at the evolution!
  // (x: T) => { !p(x) }
  // (x: T) => !p(x)
  !p(_)
}

val isWeekendDay = predicateInverter(isWorkDay)

val weekendDays3 = weekdays.filterKeys(isWeekendDay)

val weekendDays4 = weekdays.filterKeys(predicateInverter(isWorkDay))
