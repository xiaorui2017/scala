package cn.scala.study.Class


import scala.collection.mutable.ArrayBuffer

//扩大内部类的方法:类型投影
class TypeProjectionTest {

  class Student(val name: String) {}

  val students = new ArrayBuffer[TypeProjectionTest#Student]

  def register(name: String) = {
    new Student(name)
  }
}

//测试代码
/*val c1 =new TypeProjectionTest
val leo =c1.register("leo")
c1.students +=leo

val c2 =new Class
val jack=c2.register("jack")
c1.students +=jack*/
