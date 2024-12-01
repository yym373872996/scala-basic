package person.rulo.scala.basic.c01_base

object s05_Traits {

  def main(args: Array[String]): Unit = {
    // 特质是可以包含属性和方法的抽象类型，类似java的抽象类
    // scala特质可以被多继承，scala类只能被单继承
    // 特质可以不实现方法
    trait Greeter {
      def greet(name: String): Unit
    }

    // 也可以提供方法的默认实现
    trait Robot {
      def greet(name: String): Unit = println(s"Hello, $name!")
    }

    // 使用特质的默认实现
    class DefaultRobot extends Robot

    // 使用自定义实现覆盖特质的默认实现
    class CustomizableRobot(prefix: String, postfix: String) extends Robot {
      override def greet(name: String): Unit = println(prefix + name + postfix)
    }

    val robot = new DefaultRobot
    robot.greet("rulo")
    val customRobot = new CustomizableRobot("Hi, ", "!")
    customRobot.greet("fisher")
  }

}
