package exercises.oop;

public class Novel {

    private String name;
    private int yearOfRelease;

    public Novel(String name, int yearOfRelease){
        this.name = name;
        this.yearOfRelease = yearOfRelease;
    }

    public Novel copyNovel(int newYearOfRelease) {
        return new Novel(name, newYearOfRelease);
    }
}
