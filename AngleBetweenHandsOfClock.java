public class AngleBetweenHandsOfClock {

    public double angleClock(int hour, int minutes) {
        // lets find normal angle first
        // 30 mins = 180 degrees
        int minutesToSubtract = 0;
        int start = 12;
        while (start != hour) {
            minutesToSubtract += 5;
            start++;
            if (start == 13) {
                start = 1;
            }
        }
        // Now its time to find the angle
        // 30 - 180
        // 1 - 180/30
        // min - (180/30)*min
        double spentMinutes = minutes - minutesToSubtract;
        double angleNormally = ((double) 180 / (double) 30) * (double) spentMinutes;
        // Now time to calculate the angle difference due to hour hands of a clock
        // 30 - 15 diff
        // min - (15/30)*min
        double angleDeflected = ((double) 15 / (double) 30) * (double) minutes;
        // We gotta find the minimum one
        double possibleAngle1 = Math.abs(angleNormally - angleDeflected);
        double possibleAngle2 = (double) 360 - possibleAngle1;
        return Math.min(possibleAngle1, possibleAngle2);
    }

    public static void main(String[] args) {
        AngleBetweenHandsOfClock obj = new AngleBetweenHandsOfClock();
        int hour = 3;
        int minutes = 30;
        System.out.println(obj.angleClock(hour, minutes));
    }
}
