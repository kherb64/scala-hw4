trait StarfleetWarpCore {
  this: Starship =>
  // more code here ...
}

class Starship

class Enterprise extends Starship with StarfleetWarpCore

class RomulanShip

// this won't compile
//class Warbird extends RomulanShip with StarfleetWarpCore


class Starship2

trait WarpCoreEjector

trait FireExtinguisher

trait WarpCore {
  this: Starship2 with WarpCoreEjector with FireExtinguisher =>
}

// this works
class Enterprise2 extends Starship2
  with WarpCore
  with WarpCoreEjector
  with FireExtinguisher

trait WarpCore3 {
  this: {
    def ejectWarpCore3(password: String): Boolean
    def startWarpCore3(): Unit
  } =>
}

class StarShip3 {
  def startWarpCore3(): Unit = {
    // started
  }

}

class Enterprise3 extends StarShip3 with WarpCore3 {
  def ejectWarpCore3(password: String): Boolean = {
    false // sorry, no ejection possible
  }
}

trait WarpCore4 {
  def ejectWarpCore4(password: String): Boolean

  def startWarpCore4(): Unit = {}
}

val warbird = new RomulanShip with WarpCore4 {
  def ejectWarpCore4(password: String) = password == "secret"
}
