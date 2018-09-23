package cn.scala.study.Return

object forTest {

  var flag = true
  var res = 0
  var n = 0
  for (i <- 0 until 10 if flag) {
    res += i
    if (i == 4) flag = true
  }

}
