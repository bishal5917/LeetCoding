
public class ParkingSystem {

    int bCapacity;
    int mCapacity;
    int sCapacity;
    int bParked = 0;
    int mParked = 0;
    int sParked = 0;

    public ParkingSystem(int big, int medium, int small) {
        this.bCapacity = big;
        this.mCapacity = medium;
        this.sCapacity = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (bParked == bCapacity) {
                    return false;
                }
                bParked++;
                return true;
            case 2:
                if (mParked == mCapacity) {
                    return false;
                }
                mParked++;
                return true;
            case 3:
                if (sParked == sCapacity) {
                    return false;
                }
                sParked++;
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        ParkingSystem obj = new ParkingSystem(1, 1, 0);
        System.out.println(obj.addCar(1));
        System.out.println(obj.addCar(2));
        System.out.println(obj.addCar(3));
        System.out.println(obj.addCar(1));
    }
}