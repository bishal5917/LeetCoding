
public class GcdLcd {

    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        }
        return gcd(a, b - a);
    }

    public int lcd(int a, int b) {
        int greater = Math.max(a, b);
        int smallest = Math.min(a, b);
        for (int i = greater;; i += greater) {
            if (i % smallest == 0)
                return i;
        }
    }

    public static void main(String[] args) {
        GcdLcd obj = new GcdLcd();
        System.out.println(obj.gcd(18, 6));
        System.out.println(obj.lcd(15, 20));
    }
}