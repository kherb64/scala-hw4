package hw4.traits

trait Mp3BaseSoundFilePlayer extends BaseSoundFilePlayer {
  def getBasicPlayer: BasicPlayer

  def getBasicController: BasicController

  def setGain(volume: Double)
}

