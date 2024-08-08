public class WaterBottlesII {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int bottlesDrunk = 0;
        // initially no bottles will be empty
        int emptyBottles = 0;
        while (numBottles > 0 || emptyBottles >= numExchange) {
            while (emptyBottles >= numExchange) {
                numBottles += 1;
                emptyBottles -= numExchange;
                numExchange++;
            }
            // Then use numBottles and make it empty
            bottlesDrunk += numBottles;
            emptyBottles += numBottles;
            numBottles = 0;
        }
        return bottlesDrunk;
    }

    public static void main(String[] args) {
        WaterBottlesII obj = new WaterBottlesII();
        int numBottles = 13;
        int numExchange = 6;
        System.out.println(obj.maxBottlesDrunk(numBottles, numExchange));
    }
}
