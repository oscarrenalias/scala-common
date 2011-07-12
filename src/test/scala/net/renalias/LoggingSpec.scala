package net.renalias.logging

import org.specs.Specification

class LoggingSpec extends Specification with Logging {
  "The Logging trait" should {
    "log something" in {
      log.debug("This is a test log message")
      // TODO: is there any more meaningful test I could write?
      true must beTrue
    }
  }
}