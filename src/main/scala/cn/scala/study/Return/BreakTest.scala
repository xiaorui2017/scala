package cn.scala.study.Return

object BreakTest {

  import scala.util.control.Breaks._

  var res = 0
  breakable {
    for (i <- 0 until 10) {
      if (i == 5) {
        break;
      }
      res += 1
    }
  }

}
