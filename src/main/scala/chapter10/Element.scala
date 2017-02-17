package chapter10

abstract class Element {
  def demo() = {
    println("Element's implementation invoked")
  }
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height > 0) contents(0).length else 0
}

//class ArrayElement(elems: Array[String]) extends Element {
//  def contents: Array[String] = elems
//}

class ArrayElement(val contents: Array[String]) extends Element {
  final override def demo() = {
    println("ArrayElement's implementation invoked")
  }
}

final class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def height = 1

  override def width = s.length
}

class UniformElement(
    ch: Char,
    // width and height are now fields instead of methods
    override val width: Int,
    override val height: Int
) extends Element {
  override def contents = {
    val line = ch.toString * width
    Array.fill(height)(line)
  }
}

class Cat {
  val dangerous = false
}

class Tiger(
    override val dangerous: Boolean,
    private var age: Int
) extends Cat
