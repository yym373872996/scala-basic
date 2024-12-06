package person.rulo.scala.basic.c03_class

import gardening.fruits._

object s16_PackageObjects {

  def main(args: Array[String]): Unit = {
    // 使用包对象中定义的变量和方法
    for (fruit <- planted) {
      showFruit(fruit)
    }

  }

}
