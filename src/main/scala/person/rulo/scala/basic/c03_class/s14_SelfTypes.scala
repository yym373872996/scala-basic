package person.rulo.scala.basic.c03_class

object s14_SelfTypes {

  def main(args: Array[String]): Unit = {
    // 自类型用于声明一个特质必须混入其他特质
    trait User {
      def username: String
    }
    // 要在特质中使用自类型，写一个标识符，跟上要混入的另一个特质，以及 =>（例如 someIdentifier: SomeOtherTrait =>）
    trait Tweeter {
      this: User =>  // 重新赋予 this 的类型
      def tweet(tweetText: String): Unit = println(s"$username: $tweetText")
    }
    class VerifiedTweeter(val username_ : String) extends Tweeter with User {
      override def username: String = s"real $username_"
    }
    val realBeyoncé = new VerifiedTweeter("Beyoncé")
    realBeyoncé.tweet("Just spilled my glass of lemonade")
  }

}
