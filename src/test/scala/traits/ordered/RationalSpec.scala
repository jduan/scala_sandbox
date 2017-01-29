package traits.ordered

import org.scalatest._

class RationalSpec extends FlatSpec with Matchers {
  "Comparison" should "work" in {
    val half = new Rational(1, 2)
    val third = new Rational(1, 3)
    (third < half) shouldBe true
  }
}
