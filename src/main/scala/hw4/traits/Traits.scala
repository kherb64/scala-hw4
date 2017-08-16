package hw4.traits

object Foo

trait BaseSoundPlayer {
  def play()

  def close()

  def pause()

  def stop()

  def resume()
}

trait Dog2 {
  def speak(whatToSay: String)

  private var wagTail: Boolean = _

  def startWag(): Unit = {
    wagTail = true
  }

  def stopWag(): Unit = {
    wagTail = false
  }
}

class Mp3SoundPlayer extends BaseSoundPlayer {

  private var playing: Boolean = _
  private var pausedAt: Long = _

  override def play(): Unit = {
    playing = true
  }

  override def close(): Unit = {}

  override def pause(): Unit = {
    playing = false
    pausedAt = currentPosition()
  }

  override def stop(): Unit = {
    playing = false
    pausedAt = 0
  }

  def setCurrentPosition(pausedAt: Long): Unit = {}

  override def resume(): Unit = {
    setCurrentPosition(pausedAt)
    playing = true
  }

  def currentPosition(): Long = {
    0L
  }
}

abstract class SimpleSoundPlayer extends BaseSoundPlayer {
  def play(): Unit = {}

  def close(): Unit = {}
}

case class BasicPlayer()

case class BasicController()

trait Mp3BaseSoundFilePlayer extends BaseSoundPlayer {
  def getBasicPlayer: BasicPlayer

  def getBasicController: BasicController

  def setGain(volume: Double)
}