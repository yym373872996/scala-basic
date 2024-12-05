package person.rulo.scala.basic.c04_func

object s03_MultiParamLists {

  def main(args: Array[String]): Unit = {
    // 方法可以接收多个参数列表
    // 参考scala集合库中的特质Iterable
    /**
     * trait Iterable[A] {
     * ...
     * def foldLeft[B](z: B)(op: (B, A) => B): B
     * ...
     * }
     */
    // foldLeft接收一个泛型B类型的参数z作为初始值，接收一个入参为B类型和集合元素A类型，返回B类型值的函数op，最终返回B类型值
    // 简单描述就是从左到右，每次拿B值和A值计算得到新B值，再传入新B值，重复调用相同计算逻辑，直到遍历完元素，有点类似递归函数
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val res1 = numbers.foldLeft(0)((m, n) => m + n)
    val res2 = numbers.foldLeft(1.5)((m, n) => m + n)
    val res3 = numbers.foldLeft("hello")((m, n) => m + n)
    println(res1)
    println(res2)
    println(res3)
    // 给定多参列表的一部分参数列表，形成一个新函数，可以达到复用的目的
    val numberFunc = numbers.foldLeft(List[Int]())_
    val squares = numberFunc((list, i) => list:+ i*i)
    println(squares.toString())
    val cubes = numberFunc((list, i) => list:+ i*i*i)
    println(cubes.toString())
    // 如果要制定参数列表某些参数为隐式，应该使用多参列表
//    def execute(arg: Int)(implicit ec: ExecutionContext) = ???
    // 多参列表和柯里化有本质的区别（参考 https://docs.scala-lang.org/tour/multiple-parameter-lists.html）
    // Currying is the technique of converting a function that takes multiple arguments into a sequence of functions that each takes a single argument
    // 但很多时候使用两者均能达到相同的效果，以两数求和为例
    // 用多参列表的方式
    def addMultiple(n1: Int)(n2: Int) = n1 + n2
    // 两种不同的柯里化的替代实现
    def add(n1: Int, n2: Int) = n1 + n2
    val addCurried1 = (add _).curried
    val addCurried2 = (n1: Int) => (n2: Int) => n1 + n2
    // 最终得到的效果是一样的
    println(addMultiple(3)(4))
    println(addCurried1(3)(4))
    println(addCurried2(3)(4))
  }

}
