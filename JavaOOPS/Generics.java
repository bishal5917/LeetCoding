import java.util.ArrayList;
import java.util.List;

public class Generics {

    // lets take a look at wildcards now
    // ? =wildcard
    // List< ? extends Number> numbers means
    // any list of data types that extends from number
    // (byte.short,long,double,float,etc) can be passed as a parameters
    double sum(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        CustomArrayList<String> arrayListString = new CustomArrayList<>();
        arrayListString.printList();
        arrayListString.addElement("Java");
        arrayListString.addElement("Dart");
        arrayListString.addElement("Python");
        arrayListString.printList();
        arrayListString.removeElement("Python");
        arrayListString.printList();
        arrayListString.get(1);
        CustomArrayList<Integer> arrayListInteger = new CustomArrayList<>();
        arrayListInteger.printList();
        arrayListInteger.addElement(5);
        arrayListInteger.addElement(9);
        arrayListInteger.addElement(1);
        arrayListInteger.addElement(7);
        arrayListInteger.printList();
        arrayListInteger.get(8);

        // WILDCARDS CALLING SECTION
        Generics g = new Generics();
        System.out.println(g.sum(List.of(1, 2, 3, 4, 5)));
        System.out.println(g.sum(List.of(1.0, 2.0, 3.0, 4.0, 5.0)));
        System.out.println(g.sum(List.of(1000l, 2000l, 3000l, 4000l, 5000l)));

    }
}

// here T represents the type , it can be string,integer,double,etc...
class CustomArrayList<T> {

    ArrayList<T> list = new ArrayList<>();

    public void addElement(T element) {
        list.add(element);
    }

    public void removeElement(T element) {
        list.remove(element);
    }

    public void printList() {
        System.out.println(list);
    }

    public void get(int idx) {
        if (idx > list.size() - 1) {
            System.out.println("Index out of range");
        } else {
            System.out.println(list.get(idx));
        }
    }
}