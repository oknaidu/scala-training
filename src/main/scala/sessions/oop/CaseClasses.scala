package sessions.oop

object CaseClasses extends App {

  //Now the problem that we want to solve is that often for lightweight data structures which is a lot of
  //
  //the time like for class person we need to reimplement all sorts of boilerplate like companion objects
  //
  //like standard methods for serializing and for pretty printing like equals hash code to string for a
  //
  //pretty string representation and so on and so forth

  // Case classes are an exceptionally useful shorthand for defining a class and the companion object and
  //
  //a lot of sensible defaults in one go.

  case class Person(name: String, age: Int)
  // the above declaration does multiple things

  // 1. Class parameters are promoted to fields.

  val john = new Person("John", 25)
  println(john.name)
  println(john.age)

  // If we dont't put in the keyword case here the parameter name would not have been a field.

  // 2. sensible - to string

  println(john) // prints a decent  string representation

  // 3. equals and hash code implemented out of the  box
  // very useful in collections

  val person2  = new Person("John", 25)
  println(john == person2)

  // if person was not case class then thee default equals from AnyRef would be picked
  // default equals in AnyRef checks for reference

  // 4. case classes have handy copy method

  // copy creates a new instance of this case class.
  val person3 = john.copy()
  println(person3)

  // copy methods also receive named parameters
  val person4 = john.copy(age = 35)
  // above statement  will return another instance of person with the
  // same parameters as John except age which in this case is a different value 35.
  println(person4)

  // 5. case classes have companion object
  val thePerson = Person
  // the compiler has automatically created a cc object for class Person

  // Now companion objects also have some handy factory methods.
  // So if for example we create a new person called Mary we can actually call this companion objects apply

  val mary = Person("Mary", 35) //delegates to the apply method of the companion object
  // the companion object apply method does the  same thing as constructor
  // so basically we dont need the keyword new when instantiatting a case class instance

  // 6. case classes are serializable

  // 7. case classes have extractor pattern
  // hence they can be used in pattern matching

  // Case object
  //  acts like a case class except it's an object.
  case object Color {
    val purple: String = "purple"
    val red: String = "red"
  }

  // same as case classes except they dont have a cc object because they are their own cc objects

}
