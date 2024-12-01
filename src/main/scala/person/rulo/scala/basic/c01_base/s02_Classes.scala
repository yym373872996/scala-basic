package person.rulo.scala.basic.c01_base

object s02_Classes {

  def main(args: Array[String]): Unit = {
    // 用class定义一个类，类名后跟构造参数
    class Greeter(prefix: String, suffix: String) {
      def greet(name: String): Unit = println(prefix + name + suffix)
    }

    // 用new创建一个类的实例
    val greeter = new Greeter("Hello, ", "!")
    greeter.greet("rulo")
  }
}
