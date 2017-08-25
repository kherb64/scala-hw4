package at.co.sdt.herb.hw4

import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

object DecrypterApp extends App {

  object Decrypter {

    private val decoder = Base64.getDecoder

    def decrypt(text: String, key: String): String = {
      val encryptedDecoded = decoder.decode(text)
      new String(cipher(key).doFinal(encryptedDecoded))
    }

    private def cipher(key: String) = {
      val cipher = Cipher.getInstance("AES")
      val aesKey = new SecretKeySpec(key.getBytes, "AES")
      cipher.init(Cipher.DECRYPT_MODE, aesKey)
      cipher
    }

  }

  val encrypted = "O8kpg5gZ/+XMSONeL3AN7A=="

  // Replace FFFFFF and LLLLLL by the first-name and last-name of the
  // creator of Scala, respectively. First letters uppercased, rest
  // lowercased (That is "Firstname___Lastname").
  // Keep the 3 underscores in the middle.
  // The resulting String should be 16 letters long.
  val key = "Martin___Odersky"

  println("Sebastian's mobile phone number is: " + Decrypter.decrypt(encrypted, key))
}
