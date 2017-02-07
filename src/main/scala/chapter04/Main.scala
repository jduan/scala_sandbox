package chapter04

object Main extends App {
  for (season <- List("fall", "winter", "spring"))
    println(s"$season: ${ChecksumAccumulator.calculate(season)}")
}
