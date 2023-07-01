
public class AbstractConcept {

    public static void main(String[] args) {

        CookRice cookRice = new CookRice();
        cookRice.execute();
    }
}

abstract class Cooking {

    public void execute() {
        clean();
        cut();
        Mix();
        Boil();
    }

    abstract void clean();

    abstract void cut();

    abstract void Mix();

    abstract void Boil();

}

class CookRice extends Cooking {

    @Override
    void clean() {
        System.out.println("Clean Rice");
    }

    @Override
    void cut() {
        System.out.println("Cut ingredients to mix with rice");
    }

    @Override
    void Mix() {
        System.out.println("Mix rice with water and stuffs cut earlier");
    }

    @Override
    void Boil() {
        System.out.println("Boil the rice");
    }

}