
public class ComplexNumberMultiplication {

    // FORMULA
    // *(a+ib)×(x+iy)
    // = ax+(i^2)by+i(bx+ay)
    // = ax−by+i(bx+ay)
    public String complexNumberMultiply(String num1, String num2) {
        // Lets split and get values as needed
        String[] numA = num1.split("\\+|i");
        String[] numB = num2.split("\\+|i");
        int a = Integer.valueOf(numA[0]);
        int b = Integer.valueOf(numA[1]);
        int x = Integer.valueOf(numB[0]);
        int y = Integer.valueOf(numB[1]);
        int realPartVal = a * x - b * y;
        int imgPartVal = b * x + a * y;
        String ans = realPartVal + "+" + imgPartVal + "i";
        return ans;
    }

    public static void main(String[] args) {
        ComplexNumberMultiplication obj = new ComplexNumberMultiplication();
        String num1 = "1+1i";
        String num2 = "1+1i";
        System.out.println(obj.complexNumberMultiply(num1, num2));
    }
}
