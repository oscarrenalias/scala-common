package net.renalias.helpers

import java.util.UUID

object StringHelpers {
  /**
   * Generates a random string
   * @return a random string using Java's UUID class
   */
	def randomString = UUID.randomUUID().toString();

	/**
	 * Removes hyphens from the given string
	 */
	def dehyphenize(str: String) = {
		val hyp = "(-\n)".r
		hyp.replaceAllIn(str, "")
	}
}

/**
 * Please import this object to get support for a pimped String class
 */
object Implicits {
	implicit def string2pimpedstring(s:String):PimpedString = new PimpedString(s)
}

/**
 * Pimped version of the String class
 */
class PimpedString(val s:String) {
	def dehyphenize = StringHelpers.dehyphenize(s)
}