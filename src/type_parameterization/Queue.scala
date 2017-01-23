package type_parameterization

class Queue[T] (
  private val leading: List[T],
  private val trailing: List[T]
) {
  private def mirror = {
    if (leading.isEmpty)
      new Queue(trailing.reverse, Nil)
    else
      this
  }

  def head = mirror.leading.head
  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }
  def enqueue(x: T) = new Queue(leading, x :: trailing)
  def isEmpty = leading.isEmpty && trailing.isEmpty
}

object Main {
  def main(args: Array[String]): Unit = {
    var q = new Queue(List(1, 2, 3), List(4, 5, 6))
    while (!q.isEmpty) {
      println(q.head)
      q = q.tail
    }
  }
}
