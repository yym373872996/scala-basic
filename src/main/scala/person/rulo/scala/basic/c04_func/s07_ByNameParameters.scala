package person.rulo.scala.basic.c04_func

object s07_ByNameParameters {

  def main(args: Array[String]): Unit = {
    // 传名参数是会且仅会在使用时触发参数求值运算，与传值参数在调用方法时就仅发生一次求值相反
    // 在参数类型前加 => 可使参数变为传名参数
    // 下面是一个用传名参数实现while循环的例子
    def whileLoop(condition: => Boolean)(body: => Unit): Unit = {
      if (condition) {
        body
        whileLoop(condition)(body)
      }
    }

    var i = 2
    whileLoop(i > 0) {
      println(i)
      i -= 1
    }
  }

}
