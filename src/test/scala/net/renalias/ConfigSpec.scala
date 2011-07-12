package net.renalias.config

import org.specs.Specification

class ConfigSpec extends Specification {

  var config = new Config("test.conf")

	"Config" should {
		"Return None when a non-existant key is requested" in {
			config.getString("non.existant") must beNone
		}
		"Return the value wrapped in a Some if found" in {
			config.getString("valid.key") must beSomething
		}
		"Throw an exception if the key is not found when using getString_!" in {
			config.getString_!("non.existant") must throwA[ConfigKeyNotFoundException]
		}
	}
}