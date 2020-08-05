package sessions.oop

import language.postfixOps

object MethodNotations extends App {

  class Person(name: String, val age: Int) {
    def isElderTo(person: Person): Boolean  = this.age > person.age

    def >(person: Person): Boolean = this.age > person.age

    def unary_! : String = s"This a a hack"

    def isAlive : Boolean = true

    def apply(): String = s"Hi my name is $name and my age is $age"
  }

  val john = new Person("john", 25)
  val eden = new Person("Eden",20)

  println(john.isElderTo(eden))

  println(john isElderTo eden) //these two exprerssions are equivalent
  //this is called infix or operator notation
  // only works with methods that have a single parameter

  //its called operator notation because the function works like an operator
  println(john > eden)

  //the operators are methods
  println(1.+(2))

  // STYLE OF WRITING IN INFIX NOTATION IS CALLED SYNTACTIC SUGAR
  // SYNTACTIC SUGAR more reesemblene of Natural language

  // SCALA ALSO HAS PREFIX AND POSTFIX NOTATIONS
  // PLEASE GO THROUGH THEM

  //prefix notations
  val x = -1
  val z = 1.unary_- //same as above
  println(!john)

  //unary only works for + - ~ !

  // post fix notations
  println(john.isAlive)
  println(john isAlive) //same as above

  // APPLY METHOD
  println(john.apply())
  println(john()) //same as above,
  // we can basically call the object like it was a function
  // whenever the compiler sees an instance being called like a function it looks for an apply method in that class

}
