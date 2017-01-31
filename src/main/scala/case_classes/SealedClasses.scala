package case_classes

object SealedClasses {
  def describe(e: Expr) = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
    // without a "catch all", you will get a warning because the Expr class is sealed
    case _ => throw new RuntimeException
  }

  // another way of bypassing the warning
  // annotations appear at places of types
  def describe2(e: Expr) = (e: @unchecked) match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }
}
