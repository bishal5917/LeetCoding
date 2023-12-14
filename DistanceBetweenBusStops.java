public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int forwardDistance = 0;
        int backwardDistance = 0;
        int i = start;
        while (true) {
            if (i == destination) {
                break;
            }
            System.out.println(forwardDistance);
            forwardDistance = forwardDistance + distance[i];
            i = (i + 1) % distance.length;
        }
        i = start;
        while (true) {
            if (i == destination) {
                break;
            }
            i = (i - 1 + distance.length) % distance.length;
            backwardDistance = backwardDistance + distance[i];
        }

        return Math.min(forwardDistance, backwardDistance);
    }

    public static void main(String[] args) {
        int[] distance = { 1, 2, 3, 4 };
        int start = 0;
        int destination = 1;
        DistanceBetweenBusStops obj = new DistanceBetweenBusStops();
        obj.distanceBetweenBusStops(distance, start, destination);
    }

}
