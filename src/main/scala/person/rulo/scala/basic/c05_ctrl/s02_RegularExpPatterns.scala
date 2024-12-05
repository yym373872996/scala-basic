package person.rulo.scala.basic.c05_ctrl

import scala.util.matching.Regex

object s02_RegularExpPatterns {

  def main(args: Array[String]): Unit = {
    // 用.r方法使任意字符串变成一个正则表达式
    val numberPattern: Regex = "[0-9]".r
    numberPattern.findFirstMatchIn("awesomepassword") match {
      case Some(_) => println("Password OK")
      case None => println("Password must contain a number")
    }
    // 可以使用括号来同时匹配多组正则表达式
    val keyValPattern: Regex = "([0-9a-zA-Z-#() ]+): ([0-9a-zA-Z-#() ]+)".r
    val input: String =
      """background-color: #A03300;
        |background-image: url(img/header100.png);
        |background-position: top center;
        |background-repeat: repeat-x;
        |background-size: 2160px 108px;
        |margin: 0;
        |height: 108px;
        |width: 100%;""".stripMargin
    for (patternMatch <- keyValPattern.findAllMatchIn(input))
      println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")
  }

}
