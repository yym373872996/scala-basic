package person.rulo.scala.basic.c02_type

import scala.annotation.tailrec

object s04_Annotations {

  def main(args: Array[String]): Unit = {
    // 方法过时注解
    @deprecated("deprecation message", "release # which deprecates method")
    def hello = "hola"
    hello
    // 尾递归注解
    def factorial(x: Int): Int = {
      @tailrec
      def factorialHelper(x: Int, accumulator: Int): Int = {
        if (x == 1) accumulator else factorialHelper(x - 1, accumulator * x)
      }
      factorialHelper(x, 1)
    }
  }

}
