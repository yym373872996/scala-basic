package person.rulo.scala.basic.c01_base

object s04_Objects {

  def main(args: Array[String]): Unit = {
    // 对象，可以被认为是一个类的单实例，其作用等同于java的静态类
    object IdFactory {
      private var counter = 0
      def create(): Int = {
        counter += 1
        counter
      }
    }

    val newId = IdFactory.create()
    println(newId)
    val newerId = IdFactory.create()
    println(newerId)
  }

}
