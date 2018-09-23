package cn.scala.study.Class

import cn.scala.study.Class

import scala.collection.mutable.ArrayBuffer

//扩大内部类作用域的方法：伴生对象
object CompanionObjectTest {

  class Student(val name: String)

}

class CompanionObjectTest {
  val students = new ArrayBuffer[CompanionObjectTest.Student]

  def register(name: String) = {
    new Class.CompanionObjectTest.Student(name)
  }
}

//测试代码
/*val c1=new CompanionObjectTest
val leo=c1.register("leo")
c1.students +=leo
val c2=new CompanionObjectTest
val jack=c2.register("jack")
c1.students +=jack*/
