package person.rulo.scala.basic.c03_class

object s04_CaseClasses {

  def main(args: Array[String]): Unit = {
    // 样例类是 public val 类型的，因此不能被修改
    case class Message(sender: String, recipient: String, body: String)
    val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")
    println(message1.sender)  // prints guillaume@quebec.ca
//    message1.sender = "travis@washington.us"  // this line does not compile
    // 样例类可以通过浅拷贝来创建，并选择性修改部分构造参数
    val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
    val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
    println(message5.sender)  // travis@washington.us
    println(message5.recipient) // claire@bourgogne.fr
    println(message5.body)  // "Me zo o komz gant ma amezeg"
  }

}
