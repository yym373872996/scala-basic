package person.rulo.scala.basic.c04_func

object s05_PolymorphicMethods {
  def main(args: Array[String]): Unit = {
    // 多态方法，即包含泛型定义的方法，和泛型类用法类似
    def listOfDuplicates[A](x: A, length: Int): List[A] = {
      if (length < 1)
        Nil
      else
        x :: listOfDuplicates(x, length - 1)
    }
    println(listOfDuplicates(3, 4))
    println(listOfDuplicates("La", 8))
  }
}
