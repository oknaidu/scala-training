package exercises.oop;

 class Novel(val name:String, val yearOfRelease:Int) {

   def copyNovel(newYearOfRelease:Int):Novel= new Novel(name,newYearOfRelease)
}
