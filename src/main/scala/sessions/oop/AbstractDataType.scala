package sessions.oop

object AbstractDataType extends App {

  //situation where we need to leave fields and methods unimplemented  - abstract members
  abstract class Employee {
    val aType : String
    def work: Unit
  }

  //abstract classes cannot be instantiated
  // they are meant to be extended later

  class Supervisor extends Employee {
    override val aType: String = "supervisor" //override key not mandatory

    override def work: Unit = println("supervisor work")
  }

  //TRAITS
  trait Reporter {
    def reportTo(employee: Employee) : Unit //traits by default like abstract classes have abstract method
  }


  trait HasCustomerLaptop {
    val laptopType: String
  }
  class FTE extends Employee with Reporter with HasCustomerLaptop {
    override val aType: String = "fte"

    override def work: Unit = println("fte work")

    override def reportTo(employee: Employee): Unit = println(s"$aType reports to ${employee.aType}")

    override val laptopType: String = "MacBookPro"
  }

  val fte = new FTE
  val supervisor = new Supervisor
  fte.reportTo(supervisor)

  //difference between traits and abstract classes

  // simliarity - both can have abstract and non abstract methods and properties

  // 1. traits cannot have constructor parameters
  // trait SomeTrait(someparam: String) //does not compile

  // 2. Extend mutiple class but mixin mutiple traits

  // how to choose traits vs abstact class
  // traits =  behaviour
  // abstract class =  type of things

  // SCALAS TYPE HEIRARCHY

  // TYPE Any - root of all types
  // Any --> AnyRef(mapped to java.lang.Object) , all classes in scala extend from Anyref unless you say so

  // Scala.Null <-- is derived from all these types
}
