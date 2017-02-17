package chapter09

import org.scalatest._

class CurriedSpec extends FlatSpec with Matchers {
  "curriedSum" should "work" in {
    Curried.curriedSum(1)(2) shouldEqual 3
  }

  "partial application" should "work" in {
    val onePlus = Curried.curriedSum(1)_
    onePlus(2) shouldEqual 3
  }
}
