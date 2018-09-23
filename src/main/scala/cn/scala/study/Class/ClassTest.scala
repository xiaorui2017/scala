package cn.scala.study.Class

import scala.collection.mutable.ArrayBuffer

//内部类的作用域是外部类的对象

class ClassTest {

  class Student(val name: String) {}

  val students = new ArrayBuffer[String]

  def register(name: String) = {
    new Student(name)
  }

}

//测试代码
/*val  c1= new Class
val leo =c1.register("leo")
c1.students +=leo

val c2 =new Class
val jack =c2.register("jack")
c1.students +=jack*/

