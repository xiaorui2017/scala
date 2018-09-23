package cn.scala.study.Override

/*
默认情况下，如果父类中的构造函数代码，用到了会被子类重写的field; 那么出出现令人意想不到的一幕:
1、子类的构造函数（无参）调用父类的构造函数（无参）
2、父类的构造函数初始化field（结果正确）
3、父类的构造函数使用field执行其他构造代码，但是此时其他构造代码如果使用了该field，而且field要被子类重写，那么它的getter方法被重写，返回0（比如Int）
4、子类的构造函数再执行，重写field（结果也正确）
5、但是此时子类从父类继承的其他构造代码，已经出现了错误了
*/

class Student {
  val classNumber: Int = 10
  val classScores: Array[Int] = new Array[Int](classNumber)
}

/*
class PEStudent {
  override val classNumber: Int = 3
}
*/

/*
本来我们期望的是，PEStudent，可以从Student继承来一个长度为3的classScores数组
结果。。。PEStudent对象，只有一个长度为0的classScores数组

此时只能使用Scala对象继承的一个高级特性: 提前定义，在父类构造函数执行之前，先执行子类的构造函数中的某些代码
*/

class PEStudent extends {
  override val classNumber: Int = 3
} with Student