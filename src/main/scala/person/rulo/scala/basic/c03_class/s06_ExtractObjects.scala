package person.rulo.scala.basic.c03_class

import scala.util.Random

object s06_ExtractObjects {

  def main(args: Array[String]): Unit = {
    // 提取器对象是一个包含有 unapply 方法的单例对象
    // apply 方法就像一个构造器，接受参数然后创建一个实例对象
    // 反之 unapply 方法接受一个实例对象然后返回最初创建它所用的参数
    // 提取器常用在模式匹配和偏函数中
    object CustomerID {
      def apply(name: String) = s"$name--${Random.nextLong()}"
      def unapply(customerID: String): Option[String] = {
        val stringArray: Array[String] = customerID.split("--")
        if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
      }
    }
    val customerID = CustomerID("rulo")
    customerID match {
      case CustomerID(name) => println(name)
      case _ => println("Could not extract a CustomerID")
    }
  }

}
