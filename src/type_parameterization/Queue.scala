package type_parameterization.queue

// private makes the primary constructor private to prevent object creation
class Queue[T] private(
                        private val leading: List[T],
                        private val trailing: List[T]
                      ) {
  // auxiliary constructor
  def this(l: List[T]) = this(l, Nil)

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

// companion object
object Queue {
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}

object Main {
  def main(args: Array[String]): Unit = {
    //    var q = new Queue(List(1, 2, 3, 4, 5, 6))
    var q = Queue(1, 2, 3, 4, 5, 6)
    while (!q.isEmpty) {
      println(q.head)
      q = q.tail
    }
  }
}
