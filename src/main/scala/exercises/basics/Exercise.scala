package exercises.basics

object Exercise extends App {

  /**
   * 1. A greeting function (name, age) => "Hi , my name is $name and my age is $age"
   */
  def greeting(name: String, age: Int): String = {
    s"Hi, my name is $name and my age is $age"
  }


  /**
   * 2. A factorial function
   */
  def factorial(n: Int): Int = {
    def calculateFactorial(n: Int, result: Int): Int = {
      if (n == 1)
        return result;
      else
        calculateFactorial(n - 1, result * n)
    }

    calculateFactorial(n, 1)
  }


  /**
   * 3. Test if a number is prime
   */
  def isPrime(n: Int): Boolean = {

    def isPrime(n: Int, deviser: Int): Boolean = {
      if (n == 0 || n == 1)
        return false;
      else if (n == 2)
        return true;
      else {
        if (deviser > n / 2)
          return true;
        if (n % deviser == 0)
          return false;
        else
          return isPrime(n, deviser + 1)
      }


    }

    isPrime(n, 2);

  }

  println(greeting("kumar", 10))
  println(factorial(5))
  println(isPrime(11))
}
