package ExceptionHandling;

public class ExceptionHandling {

    public static void main(String[] args) {
        badCodeFunction();
    }

    private static void badCodeFunction() {
        try {
            // String name = null;
            // name.length();
            int[] nums = { 0, 1, 2 };
            System.out.println(nums[3]);
            return;
        } catch (NullPointerException e) {
            System.out.println("Null Pointer accessed");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        } catch (Exception e) {
            System.out.println("Some exception occured");
            e.printStackTrace();
        } finally {
            // whether exception occurs or not finally block runs
            // If we we have return statement at the end of try block this block runs
            System.out.println("Function completed finally");
        }
    }

}
