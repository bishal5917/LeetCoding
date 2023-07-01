
public class Interfaces {

    public static void main(String[] args) {

        // polymorphism = same code different behaviour
        KeyBoard[] games = { new DaveGame(), new MarioGame() };
        for (KeyBoard game : games) {
            game.upKey();
            game.downKey();
            game.leftKey();
            game.rightKey();
        }
    }
}

interface KeyBoard {

    abstract void upKey();

    abstract void downKey();

    abstract void leftKey();

    abstract void rightKey();

}

class DaveGame implements KeyBoard {

    @Override
    public void upKey() {
        System.out.println("Move Dave up");
    }

    @Override
    public void downKey() {
        System.out.println("Move Dave down");
    }

    @Override
    public void leftKey() {
        System.out.println("Move dave towards left");
    }

    @Override
    public void rightKey() {
        System.out.println("Move dave towards right");
    }

}

class MarioGame implements KeyBoard {

    @Override
    public void upKey() {
        System.out.println("Move Mario up");
    }

    @Override
    public void downKey() {
        System.out.println("Move Mario down");
    }

    @Override
    public void leftKey() {
        System.out.println("Move Mario towards left");
    }

    @Override
    public void rightKey() {
        System.out.println("Move Mario towards right");
    }

}