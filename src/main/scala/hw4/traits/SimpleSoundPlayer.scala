package hw4.traits

// must be declared abstract because it does not implement
// all of the BaseSoundPlayer methods
abstract class SimpleSoundPlayer extends BaseSoundPlayer {
  override def play(): Unit = ???

  override def close(): Unit = ???
}