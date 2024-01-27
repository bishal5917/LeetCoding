package AdvancedOOPS;

//Access Modifiers
// PUBLIC => can be accessed from a class inside or outside that package
// PROTECTED => can be accessed from a class within that current package and the class that extends
// PRIVATE => can only be accessed from inside that class

//class can only be declared as public/default(NONE)
//method can be declared private,public or protected

//Non Access Modifiers
//final and static
//If a class is declared as a final,it can't be extended
//If a method inside a class is declared as final,it cant be overridden

final class Animal {
}

// cant perform (Throws error)
// class Dog extends Animal{
// }

class Instrument {
    final void doJob() {
    }
}

class Guitar extends Instrument {
    // This throws error
    // void doJob() {
    // }
}

public class AccessModifiers {

    public static void main(String[] args) {
        // final variable => Immutable variable(can't be changed)
        // final int test = 5;
        // test = test + 1;
    }

}
