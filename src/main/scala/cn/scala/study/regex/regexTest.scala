package scala.study.regex

object regexTest {
  //[a-z]+: 一个或多个a~z范围的26个小写英文字母，比如hello，world
  //定义一个正则表达式，使用String类的r方法
  //此时返回的类型是scala.util.matching.Regex类的对象

  val pattern1 = "[a-z]+".r

 /* 拿到一个正则表达式以后，我们一般会用它来做什么事情？
  比如，我们会用正则表达式来匹配一些字符串，比如来看看，某个字符串是否符合表达式规定的范围之内
  比如，从一个长的字符串中，提取出来，匹配正则表达式的各个部分
*/
  val str = "hello 123 world 456"

 /* 获取一个字符串中，匹配正则表达式的部分，使用findAllIn，会获取到一个Iterator，迭代器
  然后就可以去遍历各个匹配正则的部分，去进行处理*/
  for (matchString <- pattern1.findAllIn(str)) println(matchString)

  //同理，使用findFirstIn，可以获取第一个匹配正则表达式的部分
  pattern1.findFirstIn(str)

  //使用replaceAllIn，可以将匹配正则的部分，替换掉
  pattern1.replaceFirstIn("hello world", "replacement")

  //使用replaceFirstIn，可以将第一个匹配正则的部分，替换掉
  pattern1.replaceAllIn("hello world", "replacement")

}
