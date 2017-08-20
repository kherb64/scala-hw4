val r = 1 to 100
val v = r.view
// v.force


val x = (1 to 1000).view.map { e =>
  Thread.sleep(10)
  e * 2
}

x.foreach(print)
