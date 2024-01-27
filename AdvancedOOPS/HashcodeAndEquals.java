package AdvancedOOPS;

class User {
    int id;

    User() {
    }

    User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Whenever you implement a hashcode method , you should also implement an
    // equals method
    // Your hashcode method must distribute the objects evenly among different
    // buckets
    // The condition that an hashcode method should satisfy is that,if two objects
    // are equal
    // their hashcode should also be equal,and hashcode shouldnot change unless the
    // value of the
    // object changes
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (that == null)
            return false;
        if (getClass() != that.getClass())
            return false;
        User other = (User) that;
        if (id != other.id)
            return false;
        return true;
    }
}

public class HashcodeAndEquals {

    public static void main(String[] args) {
        User user1 = new User(1);
        User user2 = new User(2);
        System.out.println(user1.equals(user2));
    }

}
