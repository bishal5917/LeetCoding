package AdvancedOOPS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClass {

    public static void main(String[] args) {
        List<String> animals = new ArrayList<String>();
        animals.add("Tiger");
        animals.add("Lion");
        animals.add("Dog");
        animals.add("Elephant");
        System.out.println(animals);
        Collections.sort(animals);
        System.out.println(animals);
        // Here we sorted them in alphabetical order.
        // But lets sort in order of their length
        Collections.sort(animals,
                // this is an anonymous inner class
                // It doesnot have a name
                // It just does what it gotta do
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return Integer.compare(o1.length(), o2.length());
                    }

                });
        System.out.println(animals);

    }
}
