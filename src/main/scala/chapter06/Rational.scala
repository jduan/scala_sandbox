package chapter06

class Rational(n: Int, d: Int) {
  require(d != 0, "denominator must not be zero!")

  private val g: Int = gcd(n.abs, d.abs)

  val numer: Int = n / g
  val denom: Int = d / g

  // auxiliary constructor
  def this(n: Int) = this(n, 1)

  override def toString: String = s"$numer/$denom"

  def +(that: Rational): Rational = {
    new Rational(
      this.numer * that.denom + this.denom * that.numer,
      this.denom * that.denom)
  }

  def +(i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def -(that: Rational): Rational = {
    new Rational(
      this.numer * that.denom - this.denom * that.numer,
      this.denom * that.denom)
  }

  def -(i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def *(that: Rational): Rational =
    new Rational(this.numer * that.numer, this.denom * that.denom)

  def *(i: Int): Rational =
    new Rational(numer * i, denom)

  def /(that: Rational): Rational =
    new Rational(this.numer * that.denom, this.denom * that.numer)

  def /(i: Int): Rational =
    new Rational(numer, denom * i)

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
