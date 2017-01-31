package case_classes

import org.scalatest._

class PatternGuardSpec extends FlatSpec with Matchers {
  "simplifyAdd" should "work" in {
    PatternGuard.simplifyAdd(BinOp("+", Var("x"), Var("x"))) shouldEqual BinOp("*", Var("x"), Number(2))
  }
}
