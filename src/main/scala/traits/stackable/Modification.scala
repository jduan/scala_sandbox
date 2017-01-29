package traits.stackable

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) = super.put(x * 2)
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x + 1)
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int): Unit = {
    if (x >= 0) super.put(x)
  }
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]()
  def get() = buf.remove(0)
  def put(x: Int) = buf.append(x)
}

object Main {
  def main(args: Array[String]): Unit = {
    val q = new BasicIntQueue
    q.put(10)
    q.put(20)

    println("first element: " + q.get())
    println("second element: " + q.get())

    // doubling
    val q2 = new BasicIntQueue with Doubling with Incrementing with Filtering
    q2.put(-1)
    q2.put(0) // 2
    q2.put(1) // 4
    q2.put(10) // 22
    println("first element: " + q2.get())
    println("second element: " + q2.get())
    println("third element: " + q2.get())
  }
}
