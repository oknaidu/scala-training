package exercises.oop

object MethodNotations extends App {

  class Person(val name: String, val age: Int) {
    def +(nickName:String):Person = new Person(s"$name $nickName",age )
  }

  val mary = new Person("Mary", 30)


  /**
   * overload the + operator for Person class so that the below code compiles
   * returns a new Person with same name with the nick name appended to name
   */
  val anotherPerson : Person = mary + "nick name"

  println(anotherPerson.name)
}
