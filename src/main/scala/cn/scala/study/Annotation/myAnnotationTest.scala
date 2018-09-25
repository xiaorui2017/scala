package scala.study.Annotation

class myAnnotationTest(var name: String) extends annotation.Annotation {

  @myAnnotationTest(name = "myAnnotationTest") class myTest

  //@myAnnotationTest("myAnnotationTest") class myTest
}


