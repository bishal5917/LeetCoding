public class WateringPlantsII {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int aliceTotalCapacity = capacityA;
        int bobTotalCapacity = capacityB;
        int refillCount = 0;
        // Using the classic two pointers approach
        int i = 0;
        int j = plants.length - 1;
        while (i <= j) {
            // separate case if i and j are equal
            if (i == j) {
                // the one with more water should water the plant
                if (capacityA >= capacityB) {
                    if (capacityA < plants[i]) {
                        refillCount += 1;
                    }
                } else if (capacityA < capacityB) {
                    if (capacityB < plants[i]) {
                        refillCount += 1;
                    }
                }
                break;
            }
            // NORMAL PROCESS SIMULATION AS IN QUESTION
            if (capacityA >= plants[i]) {
                // no refill,water the plant
                capacityA -= plants[i];
            } else {
                refillCount += 1;
                capacityA = aliceTotalCapacity;
                capacityA -= plants[i];
            }
            if (capacityB >= plants[j]) {
                // no refill,water the plant
                capacityB -= plants[j];
            } else {
                refillCount += 1;
                capacityB = bobTotalCapacity;
                capacityB -= plants[j];
            }
            i += 1;
            j -= 1;
        }
        return refillCount;
    }

    public static void main(String[] args) {
        WateringPlantsII obj = new WateringPlantsII();
        int[] plants = { 1, 2, 4, 4, 5 };
        int capacityA = 6;
        int capacityB = 5;
        System.out.println(obj.minimumRefill(plants, capacityA, capacityB));
    }
}
