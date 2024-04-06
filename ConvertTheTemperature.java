import java.util.Arrays;

public class ConvertTheTemperature {

    public double[] convertTemperature(double celsius) {
        double k = celsius + 273.15;
        double f = celsius * 1.80 + 32.00;
        return new double[] { k, f };
    }

    public static void main(String[] args) {
        ConvertTheTemperature obj = new ConvertTheTemperature();
        double celsius = 36.50;
        double[] ans = obj.convertTemperature(celsius);
        System.out.println(Arrays.toString(ans));
    }
}