package cn.scala.study.IO

//结合Java IO流，读取任意文件
//spark的源码实际上是由scala和java共同编写而成的，Java的多线程
//scala，本身的编程语言的功能，就不是特别的强大和完善，比如说，scala甚至不能很方便地写文件，必须依赖于java的io流才可以

class copyFlieTest {

  import java.io._

  //案例: 结合java IO流，做一个文件拷贝的案例
  val fis = new FileInputStream(new File("C://Users//Administrator//Desktop//test.txt"))
  val fos = new FileOutputStream(new File("C://Users//Administrator//Desktop//test3.txt"))

  val buf = new Array[Byte](1024)
  fis.read(buf)
  fos.write(buf, 0, 1024)

  fis.close()
  fos.close()


  //结合Java IO流，写文件
  val pw = new PrintWriter("C://Users//Administrator//Desktop//test4.txt")
  pw.println("Hello World")
  pw.close()


  //递归遍历子目录
  def getSubdirIterator(dir: File): Iterator[File] = {
    val childDirs = dir.listFiles.filter(_.isDirectory)
    childDirs.toIterator ++ childDirs.toIterator.flatMap(getSubdirIterator _)
  }

  val iterator = getSubdirIterator(new File("C://Users//Administrator//Desktop"))

  for (d <- iterator) println(d)

  //序列化以及反序列化（Java序列化和反序列化机制）
  //如果要序列化，那么就必须让类，有一个@SerialVersionUID，定义一个版本号
  //要让类继承一个Serializable trait
  @SerialVersionUID(42L) class Person(val name: String) extends Serializable

  val leo = new Person("leo")

  import java.io._

  val oos = new ObjectOutputStream(new FileOutputStream("C://Users//Administrator//Desktop//test.obj"))
  oos.writeObject(leo)
  oos.close()

  val ois = new ObjectInputStream(new FileInputStream("C://Users//Administrator//Desktop//test.obj"))
  val restoredLeo = ois.readObject().asInstanceOf[Person]
  restoredLeo.name

}
