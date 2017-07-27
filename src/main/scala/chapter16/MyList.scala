package chapter16

object MyList {
  // insertion sort a list
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => insert(x, isort(xs1))
  }

  private def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x < y) x :: xs else y :: insert(x, ys)
  }

  // list concatenation
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case x :: xs1 => x :: concat(xs1, ys)
  }

  // list concatenation (tail call)
  def concat2[T](xs: List[T], ys: List[T]): List[T] = {
      def helper(xs: List)
  }
}
