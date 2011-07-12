package net.renalias.config

import net.lag.configgy.Configgy
import net.renalias.logging._

case class ConfigKeyNotFoundException(key:String) extends Exception("No value foound for key:" + key)

/**
 * Basic class used for handling configuration files. It's largely based on Configgy with a couple of additional
 * useful functions
 *
 * Requires the name of the configuration file as part of the call to the constructor:
 *
 * val config = new Config("myconfigfile.conf")
 *
 * However it's much more convenient to create an own Config object that extends the Config class with the file
 * name already provided:
 *
 * object Config extends Config("myconfigfile.conf")
 * val value = Config.getString_!("my_key")
 *
 * Please note that the configuration file can be anywhere in the classpath, and the file is loaded using the class
 * own's class loader
 */
class Config(val file:String) extends Logging {

	lazy val config = {
		Configgy.configureFromResource(file, getClass.getClassLoader)
		Configgy.config
	}

	def getString(key: String) = config.getString(key).orElse({log.warn("No configuration value found for key:" + key); None})

	/**
	 * Return the value for the given key, or throw an Exception if None
	 */
	def getString_!(key:String) = getString(key).getOrElse({throw new ConfigKeyNotFoundException(key); ""})

	def getString(key: String, default: String) = config.getString(key, default)
	def getInt(key:String, default: Int) = config.getInt(key, default)
}