package person.rulo.scala.basic.c05_ctrl

object s03_ForExpressions {
  def main(args: Array[String]): Unit = {
    // 在for表达式中使用yield采集每次循环的结果形成一个集合
    // 产生的集合类型和遍历的集合类型一致，比如下面是List
    // for表达式中可以携带if守卫
    case class User(name: String, age: Int)
    val userBase = List(
      User("Travis", 28),
      User("Kelly", 33),
      User("Jennifer", 44),
      User("Dennis", 23),
    )
    val twentySomethings =
      for (user <- userBase if user.age >= 20 && user.age < 30)
        yield user.name
    twentySomethings.foreach(println)
    // for表达式中也允许使用嵌套for
    // 以下实现了在0到n-1中得到所有和为v的一对数的组合
    def twoSum(n: Int, v: Int) =
      for (i <- 0 until n;
           j <- 0 until n if i + j == v)
        yield (i, j)
    twoSum(10, 10).foreach(println)
    
  }
}
