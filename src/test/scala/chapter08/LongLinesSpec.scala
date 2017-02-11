package chapter08

import org.scalatest._

class LongLinesSpec extends FlatSpec with Matchers {
  "processFile" should "work" in {
    LongLines.processFile("/tmp/1", 40)
  }

  "processFile2" should "work" in {
    LongLines.processFile2("/tmp/1", 40)
  }
}
