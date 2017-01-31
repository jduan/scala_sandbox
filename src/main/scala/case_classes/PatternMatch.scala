package case_classes

object PatternMatch {
  val pi = Math.PI

  def simplifyTop(expr: Expr) = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _ => expr
  }

  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    // case PI => "pi from Math"
    // case pi => "pi from Math"
    case `pi` => "pi from Math too"
    case BinOp("+", e, Number(0)) => "a deep match"
    case List(0, _, _) => "found it"
    // _* matches zero or more elements
    case List(1, _*) => "found it again"
    case (a, b, c) => "it's a tuple"
    case s: String => "string length: " + s.length
    case m: Map[_, _] => "map size: " + m.size
    case somethingElse => "something else: " + somethingElse
  }

  def isIntIntMap(x: Any) = x match {
    // due to "type erasure", there's no info about type parameters maintained at runtime
    case m: Map[Int, Int] => true
    case _ => false
  }

  // arrays in Java are handled specially!
  def isStringArray(x: Any) = x match {
    case a: Array[String] => true
    case _ => false
  }

  // @ is used to capture the matched object
  def variableBinding(expr: Expr) = expr match {
    case UnOp("abs", e@UnOp("abs", _)) => e
    case _ =>
  }
}
