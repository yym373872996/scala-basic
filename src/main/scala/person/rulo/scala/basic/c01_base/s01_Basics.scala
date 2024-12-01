package person.rulo.scala.basic.c01_base

object s01_Basics {

  // 主方法，程序入口
  def main(args: Array[String]): Unit = {
    /** 表达式  */
    // 常量，推断类型
    val a = 1 + 1
    // 常量，显式声明类型
    val b: Int = 1 + 2
    // 变量
    var x = 1 + 1
    x = 3 // This compiles because "x" is declared with the "var" keyword.
    println(x * x) // 9
    /** 代码块 */
    // 代码块，最后一行的结果为整个代码块的返回值
    println({
      val x = 1 + 1
      x + 1
    }) // 3
    /** 函数 */
    // 函数，可以被命名
    val addOne: Int => Int = (x: Int) => x + 1
    println(addOne(1))
    // 函数，接收多个参数
    val add = (x: Int, y: Int) => x + y
    println(add(1, 2))
    // 函数，无参
    val getAnswer = () => 42
    println(getAnswer())
    /** 方法 */
    // 方法和函数的区别，方法由def定义
    def add2(x:Int, y:Int): Int = x + y
    println(add2(2, 3))
    // 方法可以携带多个参数列表
    def addThenMultiply(x:Int, y:Int)(z: Int): Int = (x + y) * z
    println(addThenMultiply(1, 2)(3))
    // 方法，无参
    def name: String = System.getProperty("user.name")
    println(s"hello, $name!")
    // 方法可以有多行表达式，最后一行结果为方法的返回值
    def getSquareString(input: Double): String = {
      val square = input * input
      square.toString
    }
    println(getSquareString(2.5)) // 6.25
  }

}
