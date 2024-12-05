package person.rulo.scala.basic.c02_type

object s02_Tuples {

  def main(args: Array[String]): Unit = {
    // 创建一个二元组，类型为 Tuple2[String, Int]
    val ingredient = ("Sugar", 25)
    // 用下划线访问元组中的元素
    println(ingredient._1)
    println(ingredient._2)
    // 解构元组
    val (name, quantity) = ingredient
    println(name)
    println(quantity)
    // 元组解构可用于模式匹配
    val planetDistanceFromSun = List(
      ("Mercury", 57.9),
      ("Venus", 108.2),
      ("Earth", 149.6),
      ("Mars", 227.9),
      ("Jupiter", 778.3)
    )
    planetDistanceFromSun.foreach {
      case ("Mercury", distance) => println(s"Mercury is $distance millions km far from Sun")
      case p if (p._1 == "Venus") => println(s"Venus is ${p._2} millions km far from Sun")
      case p if (p._1 == "Earth") => println(s"Blue planet is ${p._2} millions km far from Sun")
      case _ => println("Too far....")
    }
    // 元组解构用于for表达式
    val numPairs = List((2, 5), (3, -7), (20, 56))
    for ((a, b) <- numPairs) {
      println(a * b)
    }

  }

}
