package net.renalias.helpers

import java.util.UUID

object StringHelpers {
  /**
   * Generates a random string
   * @return a random string using Java's UUID class
   */
	def randomString = UUID.randomUUID().toString();
}