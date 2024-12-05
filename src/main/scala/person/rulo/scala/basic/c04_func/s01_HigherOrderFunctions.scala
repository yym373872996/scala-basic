package person.rulo.scala.basic.c04_func

object s01_HigherOrderFunctions {

  def main(args: Array[String]): Unit = {
    // 高阶函数是指使用其他函数作为参数、或者返回一个函数作为结果的函数
    val salaries = Seq(20000, 70000, 40000)
    val doubleSalary = (x: Int) => x * 2
    val newSalaries = salaries.map(doubleSalary)
    println(newSalaries)
    // 可以用匿名函数简化代码
    val newSalaries2 = salaries.map(x => x * 2)
    println(newSalaries2)
    // 还可以用_替代参数名
    val newSalaries3 = salaries.map(_ * 2)
    println(newSalaries3)
    // 当作为高阶函数参数传入时，方法会被强制转换为函数
    case class WeeklyWeatherForecast(temperatures: Seq[Double]) {
      private def convertCtoF(temp: Double) = temp * 1.8 + 32
      def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF)
    }
    // 返回函数的函数
    def urlBuilder(ssl: Boolean, domain: String): (String, String) => String = {
      val schema = if (ssl) "https://" else "http://"
      (endpoint: String, query: String) => s"$schema$domain/$endpoint?$query"
    }
    val domain = "www.example.com"
    def getURL = urlBuilder(ssl = true, domain)
    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query)
    println(url)
  }

}
