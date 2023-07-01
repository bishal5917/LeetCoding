// package JavaOOPS;

public class Inheritance {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Bsal");
        student.setEmail("poudelb172@gmail.com");
        student.setAddress("Pokhara");
        student.setCollegeName("Bsal");
        student.setRollNo(12);
        student.setRank(1);
        student.printValues();
    }
}

class Person {
    private int id;
    private String name;
    private String email;
    private String address;

    public Person() {
        super();
        System.out.println("Person Constructor");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void printValues() {
        System.out.println(name + " " + email + " " + address + " ");
    }
}

class Student extends Person {
    private String collegeName;
    private int rollNo;
    private int rank;

    public Student() {
        // super();
        System.out.println("Student Constructor");
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void printValues() {
        super.printValues();
        System.out.println(collegeName + " " + rollNo + " " + rank + " ");
    }
}