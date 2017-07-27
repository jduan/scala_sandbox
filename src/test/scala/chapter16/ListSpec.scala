package chapter16

import org.scalatest._

class ListSpec extends FlatSpec with Matchers {
  "List literals" should "work" in {
    val fruit = List("apples", "oranges", "pears")
    fruit(0) shouldEqual "apples"
    fruit(1) shouldEqual "oranges"
    fruit(2) shouldEqual "pears"
  }

  "list type is covariant" should "work" in {
    // The empty list has type of List[Nothing]
    // Nothing is a subtype of every other Scala type.
    // Because lists are covariants, List[Nothing] is a subtype of
    // List[T] for any type T.
    val xs: List[String] = List()
    val ys: List[String] = Nil
    xs.length shouldBe 0
    ys.length shouldBe 0
  }

  "constructing lists" should "work" in {
    val fruit = "apples" :: "oranges" :: "pears" :: Nil
    val fruit2 = List("apples", "oranges", "pears")
    fruit shouldEqual fruit2

    val nums = 1 :: 2 :: 3 :: 4 :: Nil
    val nums2 = List(1, 2, 3, 4)
    nums shouldEqual nums2
  }

  "basic operations on lists" should "work" in {
    val xs = List(1, 2, 3, 4)
    xs.head shouldEqual 1
    xs.tail shouldEqual List(2, 3, 4)

    // Because head and tail throw exceptions on empty lists, you should avoid using them.
    // Instead, use pattern matching!
    assertThrows[NoSuchElementException] {
      Nil.head
    }

    assertThrows[UnsupportedOperationException] {
      Nil.tail
    }

    Nil.isEmpty shouldBe true
  }

  "pattern matching" should "work" in {
    val fruit = "apples" :: "oranges" :: "pears" :: Nil
    val List(a, b, c) = fruit
    a shouldEqual "apples"
    b shouldEqual "oranges"
    c shouldEqual "pears"

    val d :: e :: rest = fruit
    d shouldEqual "apples"
    e shouldEqual "oranges"
    rest shouldEqual List("pears")

    MyList.isort(List(3, 2, 1)) shouldEqual List(1, 2, 3)
    MyList.isort(List(3, 2, 1, 5, 7, 0, -3)) shouldEqual List(-3, 0, 1, 2, 3, 5, 7)
  }

  "first-order functions" should "work" in {
    // list concatenation
    List(1, 2) ::: List(3, 4, 5) shouldEqual List(1, 2, 3, 4, 5)
    // associate to the right
    List(1, 2) ::: List(3, 4, 5) ::: List(6, 7) shouldEqual List(1, 2, 3, 4, 5, 6, 7)
    MyList.concat(List(1, 2), List(3, 4, 5)) shouldEqual List(1, 2, 3, 4, 5)

    //
  }
}
