package type_parameterization.variance

import type_parameterization.queue.Queue

class Cell[T](init: T) {
  private[this] var current = init
  def get = current
  def set(x: T) = { current = x}
}

//class StrangeIntQueue extends Queue[Int] {
//  override def enqueue(x: Int) = {
//    println(math.sqrt(x))
//    super.enqueue(x)
//
//}
//
//object Main {
//  def main(args: Array[String]): Unit = {
//    val cell = new Cell("hello")
//    println(cell.get)
//
//    val a1 = Array("abc")
//    // The next line won't compile because arrays in Scala are not covariant!
//    // val a2: Array[Any] = a1
//  }
//}
