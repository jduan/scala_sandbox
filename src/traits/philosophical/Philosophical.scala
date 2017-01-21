package traits.philosophical

trait Philosophical {
  def philosophize() = {
    println("I consume money, there I am!")
  }
}

class Animal
trait HasLegs

class Frog extends Animal with Philosophical with HasLegs {
  override def toString = "green"

  override def philosophize(): Unit = {
    println("It ain't easy being " + toString + "!")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val frog = new Frog
    frog.philosophize()

    val phil: Philosophical = new Frog
    phil.philosophize()
  }
}