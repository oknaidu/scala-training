package exercises.oop;

public class Writer {

    public String firstName;
    public String lastName;
    public int age;

    public Writer(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }
}
