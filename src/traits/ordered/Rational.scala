package traits.ordered

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  val numer = n
  val denom = d

  override def compare(that: Rational): Int = {
    (this.numer * that.denom) - (that.numer * this.denom)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val half = new Rational(1, 2)
    val third = new Rational(1, 3)
    println("half < third: " + (half < third))
    println("half <= third: " + (half <= third))
    println("half > third: " + (half > third))
    println("half >= third: " + (half >= third))
  }
}
