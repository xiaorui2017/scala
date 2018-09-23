package cn.scala.study.Return

//跳出for循环
object whileTest {

  var flag = true
  var res = 0
  var n = 0
  while (flag) {
    res += n
    n += 1
    if (n == 5) {
      flag = false
    }

  }
}
