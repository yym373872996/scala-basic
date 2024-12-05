package person.rulo.scala.basic.c03_class

import scala.math.{Pi, pow}

object s05_SingletonObjects {

  def main(args: Array[String]): Unit = {
    // 单例对象是一种特殊的类，有且只有一个实例，类似java的静态类
    // 和惰性变量一样，单例对象是延迟创建的，当它第一次被使用时创建
    object Logger {
      def info(message: String): Unit = println(s"INFO: $message")
    }
    Logger.info("this is an info log")
    // 当一个单例对象和某个类共享一个名称时，这个单例对象被称为伴生对象
    // 类和它的伴生对象可以互相访问其私有成员
    // 使用伴生对象来定义那些在伴生类中不依赖于实例化对象而存在的成员变量或者方法
    case class Circle(radius: Double) {
      import Circle._
      def area: Double = calculateArea(radius)
    }
    object Circle {
      private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
    }
    val circle1 = Circle(5.0)
    println(circle1.area)
    // 伴生对象也可以包含工厂方法
    class Email(val username: String, val domainName: String)
    object Email {
      def fromString(emailString: String): Option[Email] = {
        emailString.split('@') match {
          case Array(a, b) => Some(new Email(a, b))
          case _ => None
        }
      }
    }
    val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
    scalaCenterEmail match {
      case Some(email) => println(
        s"""Registered an email
           |Username: ${email.username}
           |Domain name: ${email.domainName}
     """)
      case None => println("Error: could not parse email")
    }
  }

}
