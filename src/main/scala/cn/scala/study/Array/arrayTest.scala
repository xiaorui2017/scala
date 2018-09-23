package cn.scala.study.Array

object arrayTest {
  //多维数组，外层3个数组，内层4个数组
  val multiDimArr1 = Array.ofDim[Double](3, 4)
  multiDimArr1(0)(0) = 1.0
  //不规则多维数组
  val multiDimArr2 = new Array[Array[Int]](3)
  multiDimArr2(0) = new Array[Int](1)
  multiDimArr2(1) = new Array[Int](2)
  multiDimArr2(2) = new Array[Int](3)
  multiDimArr2(1)(1) = 1


  //java数组与scala数组缓冲的隐式转换

  //scala代码中，直接调用JDK（java）的API，比如调用一个Java类的方法，势必可能会传入Java类型的list
  // scala中构造出来的list，其实是ArrayBuffer；你直接把scala的ArrayBuffer传入java接收ArrayList的方法肯定是不行的

  import scala.collection.JavaConversions.bufferAsJavaList
  import scala.collection.mutable.ArrayBuffer

  val command = ArrayBuffer("javac", "C:\\Users\\Administrator\\Desktop\\HelloWorld.java")
  //ProcessBuilder其实是一个java的一个类，调用此方法执行javac命令编译后面的文件
  val processBuilder = new ProcessBuilder(command)
  val process = processBuilder.start()
  val res = process.waitFor()

  import scala.collection.JavaConversions.asScalaBuffer
  import scala.collection.mutable.Buffer

  val cmd: Buffer[String] = processBuilder.command()

}
