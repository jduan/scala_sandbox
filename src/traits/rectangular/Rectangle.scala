package rectangular

class Point(val x: Int, val y: Int)

trait Rectangular {
  // abstract methods
  def topLeft: Point
  def bottomRight: Point

  // concrete methods implemented via those abstract methods
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {

}

object Main {
  def main(args: Array[String]): Unit = {
    val rect = new Rectangle(new Point(1, 1), new Point(10,10))
    println("left: " +  rect.left)
    println("right: " +  rect.right)
    println("width: " +  rect.width)
  }
}