package net.renalias

import helpers.StringHelpers
import org.specs.Specification
import helpers.Implicits._

class StringHelpersSpec extends Specification {
	"Dehyphenization" should {
		"Return strings without hyphens unmodified" in {
			StringHelpers.dehyphenize("no hyphens") mustEqual "no hyphens"
		}
		"Remove hyphens from strings" in {
			"""this is a string with hy-
phens""".dehyphenize mustEqual "this is a string with hyphens"

			"""hy-
phen1, hy-
phen2, ma-
ny hyphens!""".dehyphenize mustEqual("hyphen1, hyphen2, many hyphens!")
		}
	}
}