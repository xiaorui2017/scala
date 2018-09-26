package scala.study.xml

class loadXML {
  //加载和写入外部xml文件

  import scala.xml._
  import java.io._

  //使用scala的XML类加载
  val books = XML.loadFile("C://Users//Administrator//Desktop//books.xml")

  //使用Java的FileInputStream类加载
  val books = XML.load(new FileInputStream("C://Users//Administrator//Desktop//books.xml"))

  //使用Java的InputStreamReader类指定加载编码
  val books = XML.load(new InputStreamReader(new FileInputStream("C://Users//Administrator//Desktop//books.xml"), "UTF-8"))

  //将内存中的xml对象，写入外部xml文档
  XML.save("C://Users//Administrator//Desktop//books2.xml", books)


}
