package AdvancedOOPS;

class Person {
    // name is a member variable , it is unique per member
    private String name;
    // static variable
    // their instance remains same during all the class invocations
    private static int count = 0;

    Person(String name) {
        // super();
        this.name = name;
        count++;
    }

    public String getName() {
        return name;
    }

    static public int getCount() {
        return count;
    }
}

public class StaticMethods {

    public static void main(String[] args) {
        int countBefore = Person.getCount();
        System.out.println(countBefore);
        new Person("Java");
        new Person("Kotlin");
        int countAfter = Person.getCount();
        System.out.println(countAfter);
    }
}
