package scala.study.Extractor

class oneParameterExtractorTest {

/*  只有一个参数的提取器

  之前，已经跟大家讲解过普通的提取器
  相当于是，比如说，接收一个字符串，作为参数
  然后从字符串里面解析出来多个字段值，然后将多个字段值封装在一个tuple中
  作为Some类型的对象，返回

  现在我们来想一下，如果你的类只有一个字段
  字符串里面只有一个字段
  解析出来的一个字段，是没有办法放在tuple中的，因为scala中的tuple，规定了，必须要两个以及两个以上的值

  这个时候，在提取器，unapply方法中，只能将一个字段值，封装在Some对象中，直接返回*/


  class Person(val name: String)

  object Person {
    def unapply(input: String): Option[String] = Some(input)
  }

  val Person(name) = "leo"
}
