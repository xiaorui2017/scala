package scala.study.Extractor

class extractorTest {
/*
  apply方法

  伴生类和伴生对象的概念，companion class和companion object
  伴生对象里面，可以定义一个apply方法
  直接调用类(参数)，方式，就相当于在调用apply方法
  此时在apply方法中，通常来说（也不一定），会创建一个伴生类的对象，返回回去

  这种方式，有一个好处，创建对象呢，非常的方便
  不要每次都是new 类(参数)，类(参数)*/

 /* 提取器

  unapply方法

  和apply方法，顾名思义，那就是反过来
  apply方法，可以理解为，接收一堆参数，然后返回一个对象
  unapply方法，可以理解为，接收一个字符串，解析成一个对象的各个字段

  提取器就是一个包含了unapply方法的对象，跟apply方法正好相反
  apply方法，是接收一堆参数，然后构造出来一个对象
  unapply方法，是接收一个字符串，然后解析出对象的属性值
*/
  class Person(val name: String, val age: Int)

  object Person {

    def apply(name: String, age: Int) = new Person(name, age)

    def unapply(str: String) = {
      val splitIndex = str.indexOf(" ")
      if (splitIndex == -1) None

      else Some((str.substring(0, splitIndex), str.substring(splitIndex + 1)))
    }

  }

  val Person(name, age) = "leo 25"

  name
  age

}
