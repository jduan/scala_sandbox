package case_classes

import org.scalatest._

class PatternMatchSpec extends FlatSpec with Matchers {
  "simplifyTop" should "work" in {
    PatternMatch.simplifyTop(UnOp("-", UnOp("-", Var("x")))) shouldEqual Var("x")
    PatternMatch.simplifyTop(UnOp("-", UnOp("-", Var("x")))) shouldEqual Var("x")
  }

  "constant match" should "work" in {
    PatternMatch.describe(5) shouldEqual "five"
    PatternMatch.describe(true) shouldEqual "truth"
    PatternMatch.describe("hello") shouldEqual "hi!"
    PatternMatch.describe(Nil) shouldEqual "the empty list"
    // PatternMatch.describe(Math.PI) shouldEqual "pi from Math"
    PatternMatch.describe(Math.PI) shouldEqual "pi from Math too"
    PatternMatch.describe(10) shouldEqual "something else: 10"
    PatternMatch.describe(List(0, 1, 2)) shouldEqual "found it"
    PatternMatch.describe(List(1)) shouldEqual "found it again"
    PatternMatch.describe(List(1, 2)) shouldEqual "found it again"
    PatternMatch.describe(List(1, 2, 3)) shouldEqual "found it again"
    PatternMatch.describe((1, 2, 3)) shouldEqual "it's a tuple"
    PatternMatch.describe("hello world") shouldEqual "string length: 11"
    PatternMatch.describe(Map("hello" -> 1, "world" -> 2)) shouldEqual "map size: 2"
    PatternMatch.describe(BinOp("+", Var("x"), Number(0))) shouldEqual "a deep match"
  }

  "isIntIntMap" should "work" in {
    PatternMatch.isIntIntMap(Map[Int, Int](1 -> 1, 2 -> 2)) shouldBe true
    PatternMatch.isIntIntMap(Map[String, String]("hello" -> "world")) shouldBe true
  }

  "isStringArray" should "work" in {
    PatternMatch.isStringArray(Array("abc")) shouldBe true
    PatternMatch.isStringArray(Array(1, 2, 3)) shouldBe false
  }
  "variable binding" should "work" in {
    val expr = UnOp("abs", UnOp("abs", Var("x")))
    PatternMatch.variableBinding(expr) shouldEqual UnOp("abs", Var("x"))
  }
}
