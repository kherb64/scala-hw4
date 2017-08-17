
val sum3 = (a: Int, b: Int, c: Int) => a + b + c

val f12 = sum3(1, 2, _: Int)
f12(6)

def wrap(prefix: String, html: String, suffix: String) = {
  prefix + html + suffix
}

val wrapWithDiv = wrap("<div>", _: String, "</div>")

def wrapWithDiv2(s: String) = {
  wrap("<div>", s, "</div>")
}

wrapWithDiv("<p>Hello, world</p>")
wrapWithDiv2("<p>Hello, world</p>")

//val wrapWithDiv3 = wrapWithDiv2(_: String)

// (s: String) => { prefix + " " + s }
def saySomething(prefix: String): (String) => String = {
  (s: String) => { prefix + " " + s }
}

val sayHello = saySomething("Hi")
sayHello.apply("Saujude")
sayHello("Al")

// piftfall!
def defineFunction(prefix: String) = {
  (s: String) => { prefix + " " + s }
}
val function = defineFunction("hurzi")

def doNothing(prefix: String) {
  (s: String) => { prefix + " " + s }
}
val noFunction: Unit = doNothing("purzel")
