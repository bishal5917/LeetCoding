public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        // Do while we still have enough bottles to exchange
        int canDrink = numBottles;
        while (numBottles >= numExchange) {
            int drink = numBottles / numExchange;
            canDrink += drink;
            int rem = numBottles % numExchange;
            numBottles = drink + rem;
        }
        return canDrink;
    }

    public static void main(String[] args) {
        WaterBottles obj = new WaterBottles();
        int numBottles = 15;
        int numExchange = 4;
        System.out.println(obj.numWaterBottles(numBottles, numExchange));
    }
}
