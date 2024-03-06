public class WateringPlants {

    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int fullCapacity = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (capacity >= plants[i]) {
                capacity -= plants[i];
                steps += 1;
            } else {
                // else gotta go back to the river to fill the water
                steps += i * 2 + 1;
                capacity = fullCapacity;
                capacity -= plants[i];
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        WateringPlants obj = new WateringPlants();
        int[] plants = { 2, 2, 3, 3 };
        int capacity = 5;
        System.out.println(obj.wateringPlants(plants, capacity));
    }
}
