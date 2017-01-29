package case_classes

import org.scalatest._

class ExprSpec extends FlatSpec with Matchers {
  "Factory method" should "work" in {
    val v = Var("x")
    v.name shouldEqual "x"
  }
}
