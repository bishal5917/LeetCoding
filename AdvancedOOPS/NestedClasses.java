package AdvancedOOPS;

class DefaultClass {
}

public class NestedClasses {

    // class inside a class is nested class
    class InnerClass {
    }

    // class inside a class that is static is static nested class
    static class StaticNestedClass {
    }

    public static void main(String[] args) {
        // InnerClass innerClassObj = new InnerClass();
        StaticNestedClass staticNestedClassObj = new StaticNestedClass();
        NestedClasses mainClassObj = new NestedClasses();
        InnerClass innerClassObj = mainClassObj.new InnerClass();
        // Here the main point is that
        // static nested class doesnot require the object of the class it is nested in
        // to create its instance
        // BUT
        // normal nested class require the object of the class it is nested in
        // to create its instance
    }
}
