package chapter09

object ByNameParameters {
  val assertionEnabled = false

  def byNameAssert(predicate: => Boolean) = {
    if (assertionEnabled && !predicate) {
      throw new AssertionError("predicate failed!")
    }
  }
}

object ByNameParametersMain extends App {
  ByNameParameters.byNameAssert(5 > 3)
  // If assertionEnable is false, you won't see an ArithmeticException
  // because the "predicate" function won't be evaluated at all.
  ByNameParameters.byNameAssert(1 / 0 == 0)
}
