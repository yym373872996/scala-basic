package person.rulo.scala.basic.c05_ctrl

object s01_PatternMatching {

  def main(args: Array[String]): Unit = {
    /** 模式匹配的结果可以作为返回值 */
    def matchTest(x: Int): String = x match {
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
    }
    println(matchTest(3))
    println(matchTest(1))
    /** 样例类结合模式匹配 */
    sealed trait Notification
    case class Email(sender: String, title: String, body: String) extends Notification
    case class SMS(caller: String, message: String) extends Notification
    case class VoiceRecording(contactName: String, link: String) extends Notification
    def showNotification(notification: Notification): String = {
      notification match {
        case Email(sender, title, _) =>
          s"You got an email from $sender with title: $title"
        case SMS(number, message) =>
          s"You got an SMS from $number! Message: $message"
        case VoiceRecording(name, link) =>
          s"You received a Voice Recording from $name! Click the link to hear it: $link"
      }
    }
    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
    println(showNotification(someSms))
    println(showNotification(someVoiceRecording))
    /** 模式匹配可以带if守卫 */
    def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
      notification match {
        case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
          "You got an email from special someone!"
        case SMS(number, _) if importantPeopleInfo.contains(number) =>
          "You got an SMS from special someone!"
        case other =>
          showNotification(other) // nothing special, delegate to our original showNotification function
      }
    }
    val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")
    val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
    val importantSms = SMS("867-5309", "I'm here! Where are you?")
    println(showImportantNotification(someSms, importantPeopleInfo)) // prints You got an SMS from 123-4567! Message: Are you there?
    println(showImportantNotification(someVoiceRecording, importantPeopleInfo)) // prints You received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
    println(showImportantNotification(importantEmail, importantPeopleInfo)) // prints You got an email from special someone!
    println(showImportantNotification(importantSms, importantPeopleInfo)) // prints You got an SMS from special someone!
    /** 模式匹配作用在类型上 */
    sealed trait Device
    case class Phone(model: String) extends Device {
      def screenOff = "Turning screen off"
    }
    case class Computer(model: String) extends Device {
      def screenSaverOn = "Turning screen saver on..."
    }
    def goIdle(device: Device): String = device match {
      case p: Phone => p.screenOff
      case c: Computer => c.screenSaverOn
    }
    println(goIdle(Computer("my mbp")))
    // 可以绑定变量到匹配的模式上
    def goIdleWithModel(device: Device): String = device match {
      case p @ Phone(model) => s"$model: ${p.screenOff}"
      case c @ Computer(model) => s"$model: ${c.screenSaverOn}"
    }
    println(goIdleWithModel(Phone("my iphone")))
  }

}
