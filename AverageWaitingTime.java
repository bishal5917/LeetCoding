public class AverageWaitingTime {

    public double averageWaitingTime(int[][] customers) {
        double total = 0;
        int starting = customers[0][0];
        for (int[] customer : customers) {
            int arrivedAt = customer[0];
            int timeRequires = customer[1];
            // Now the chef prepares
            starting = Math.max(starting, arrivedAt);
            starting += timeRequires;
            double waited = starting - arrivedAt;
            total += waited;
        }
        double avg = total / (double) customers.length;
        return avg;
    }

    public static void main(String[] args) {
        AverageWaitingTime obj = new AverageWaitingTime();
        int[][] customers = { { 5, 2 }, { 5, 4 }, { 10, 3 }, { 20, 1 } };
        System.out.println(obj.averageWaitingTime(customers));
    }
}
