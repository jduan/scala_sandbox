package chapter04

import org.scalatest._

class ChecksumAccmulatorSpec extends FlatSpec with Matchers {
  "Companion Object" should "work" in {
    ChecksumAccumulator.calculate("hello") shouldEqual -20
  }
}
