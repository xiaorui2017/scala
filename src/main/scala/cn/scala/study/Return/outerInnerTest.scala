package cn.scala.study.Return

object outerInnerTest {

  def add_outer() = {
    var res = 0

    def add_inner(): Unit = {
      for (i <- 0 until 10) {
        if (i == 5) {
          return
        }
        res += i
      }
    }

    add_inner()
    res
  }


}
