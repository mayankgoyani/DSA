import java.util.Arrays;

class Main {
    static int[] rotate(int[] nums) {
        int prev = nums[nums.length -1];
        for(int i=0; i < nums.length; i++){
            int temp = nums[i];
            nums[i] = prev;
            prev = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 5, 6 };
        nums = rotate(nums);
        System.out.println(Arrays.toString(nums));
    }
}