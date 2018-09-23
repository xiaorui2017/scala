package cn.scala.study.IO

import scala.io.Source

class fileTest {

  //方法一: 使用Source.getLines返回的迭代器
  val source1 = Source.fromFile("C://Users//Administrator//Desktop//test.txt", "UTF-8")
  val lineIterator = source1.getLines
  for (line <- lineIterator) println(line)

  //方法二: 将Source.getLines返回的迭代器，转换成数组

  //这里说明一点: 一个BufferedSource对象的getLines方法，只能调用一次，
  // 一次调用完之后，遍历了迭代器里所有的内容，就已经把文件里的内容读取完了
  //如果反复调用source.getLines，是获取不到内容的
  //此时，必须重新创建一个BufferedSource对象

  val source2 = Source.fromFile("C://Users//Administrator//Desktop//test.txt", "UTF-8")
  val lines2 = source2.getLines.toArray
  for (line <- lines2) println(line)

  //方法三: 调用Source.mkString，返回文本中所有的内容
  val source3 = Source.fromFile("C://Users//Administrator//Desktop//test.txt", "UTF-8")
  val lines3 = source3.mkString

  //使用完BufferedSource对象之后，调用BufferedSource.close方法，关闭IO流资源

  //-----------------------------------------------------------

  //遍历一个文件中的每一个字符

  //BufferedSource，也实现了一个Iterator[Char]的这么一个trait

  val source4 = Source.fromFile("C://Users//Administrator//Desktop//test.txt", "UTF-8")
  for (c <- source4) print(c)
  //----------------------------------------------------------
  //从URL以及字符串中读取字符

  val source5 = Source.fromURL("http://www.baidu.com", "UTF-8")
  val source6 = Source.fromString("Hello World")


}
