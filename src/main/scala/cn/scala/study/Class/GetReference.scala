package cn.scala.study.Class

//内部类获取外部类引用
class GetReference(val name: String) {
  outer =>

  class Student(val name: String) {
    def introduceMyself = "Hello, I'm" + name + "I'm very happy to join class" + outer.name
  }

  def register(name: String) = {
    new Student(name)
  }
}

//测试代码

/*val c1=new GetReference("c1")
val leo=c1.register("leo")
leo.introduceMyself*/
