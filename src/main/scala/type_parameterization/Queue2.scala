package type_parameterization.queue2

trait Queue[T] {
  def head: T
  def tail: Queue[T]
  def enqueue(x: T): Queue[T]
  def isEmpty: Boolean
}

object Queue {
  def apply[T](xs: T*): Queue[T] = new QueueImpl[T](xs.toList, Nil)

  private class QueueImpl[T](
                          private val leading: List[T],
                          private val trailing: List[T]
                        ) extends Queue[T] {
    def mirror = {
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this
    }

    def head: T = mirror.leading.head

    def tail: Queue[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) = new QueueImpl(leading, x :: trailing)

    def isEmpty = leading.isEmpty && trailing.isEmpty
  }
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