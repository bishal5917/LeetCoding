
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum=0;
        int pivotIdx=-1;
        for (int item :nums){
            totalSum+=item;
        }

        for (int i=0;i<nums.length;i++){
            int rightSum = totalSum-leftSum-nums[i];
            if (leftSum==rightSum){
                pivotIdx=i;
                break;
            }
            leftSum+=nums[i];
        }

        System.out.println(pivotIdx);
        return pivotIdx;
    }

    public static void main(String[] args) {
    FindPivotIndex obj = new FindPivotIndex();
    int[] nums = { 1, 7, 3, 6, 5, 6};
    obj.pivotIndex(nums);
    }
}