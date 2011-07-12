package net.renalias.logging

import org.slf4j.{ Logger ⇒ SLFLogger, LoggerFactory ⇒ SLFLoggerFactory }

/**
 * Common trait for logging. Shamelessly ripped from the Akka source code
 */

object Logger {
  def apply(logger: String): SLFLogger = SLFLoggerFactory getLogger logger
  def apply(clazz: Class[_]): SLFLogger = apply(clazz.getName)
  def root: SLFLogger = apply(SLFLogger.ROOT_LOGGER_NAME)
}

/**
 * Mix in this trait with classes to provide logging capabilities via the <pre>log</pre>
 * object.
 */
trait Logging {
  @transient lazy val log = Logger(this.getClass.getName)
}