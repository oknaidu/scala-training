package sessions.oop


object Objects extends App {

  object Person { //type + the only instance
    //"static"/ class level functionality
    val title : String = "Sir"

    def createPerson(firstname: String, lastName: String): Person = new Person(firstname + " "+ lastName)
    def apply(firstname: String, lastName: String): Person = new Person(firstname + " "+ lastName)
  }

  println(Person.title)

  val john = Person
  val mary = Person
  println(john == mary)

  class Person(name: String) {
    //instance level functionality
    def greet = s"Hello ${Person.title} $name"
  }

  //object+class in the same scope is called Companion object

  val person = Person.createPerson("John","Smith")
  println(person.greet)

  val person1 = Person.apply("John","Smith")
  val person2 = Person("John","Smith")
  println(person2.greet)

  // Scala applications =  Scala object with
  // def main(args: Array[String]): Unit
}
