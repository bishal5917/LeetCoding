public class NumberOfLaserBeamsInBank {

    public int numberOfBeams(String[] bank) {
        int beams = 0;
        int prevFloorLaserBeams = 0;
        // Lets do this
        for (String floor : bank) {
            int thisFloorBeams = 0;
            for (char c : floor.toCharArray()) {
                if (c == '1') {
                    thisFloorBeams += 1;
                    beams += prevFloorLaserBeams;
                }
            }
            prevFloorLaserBeams = thisFloorBeams != 0 ? thisFloorBeams : prevFloorLaserBeams;
        }
        return beams;
    }

    public static void main(String[] args) {
        NumberOfLaserBeamsInBank obj = new NumberOfLaserBeamsInBank();
        String[] bank = { "011001", "000000", "010100", "001000" };
        System.out.println(obj.numberOfBeams(bank));
    }
}
