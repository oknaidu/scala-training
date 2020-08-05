package exercises.oop

object ObjectBasics extends App {

  /**
   * 1) implement class Writer.scala(present in the same package) in Scala
   */


  /**
   * 2) implement class Novel.scala(present in the same package) in Scala
   */


  /**
   * Implement a counter class
   * a) receives a count variable as class parameter
   * b) has methods to increment and decrement the counter, method inc and dec
   * c) both methods return a new instance of counter
   * d) overloading of both methods inc and dec to receive a value by which it can be incremented or decremented
   */

  class Counter(val count: Int){

    def inc: Counter = new Counter(count+1)

    def dec: Counter = new Counter(count-1)

    def inc(count: Int) : Counter = new Counter(count+this.count)

    def dec(count: Int): Counter = new Counter(this.count-count)
  }
}
