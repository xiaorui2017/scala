package scala.study.Annotation

class annotationTest {
  /*scala中，在哪些地方可以添加注解呢？
scala中，可以给类、方法、field、local variable、constructor / method / function parameter添加注解
而且scala是支持给某个目标添加多个注解的
这里有一些特例：如果要给类的主构造函数添加注解，那么需要在构造函数前添加注解，并加上一对圆括号*/
  val scores = Map("Leo" -> 90, "Jack" -> 60)
(scores.get("Leo"): @unchecked) match { case score => println(score) }
}

