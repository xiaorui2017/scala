package scala.study.Extractor

class caseExtractorTest {
/*  样例类的提取器

  scala中的样例类，说白了，也很简单
  类似于java中的javabean，java中的JavaBean，是什么东东？

  包含了一堆属性，field; 每个field都有一对getter和setter方法*/
/*
  public class Person {

    private String name;
    private int age;

    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public int getAge() {
      return age;
    }
    public void setAge(int age) {
      this.age = age;
    }

  }*/

  //scala中的样例类，默认就是提供apply方法和unapply方法的

  case class Person(name: String, age: Int)

  val p = Person("leo", 25)

  p match {
    case Person(name, age) => println(name + ": " + age)
  }


}
