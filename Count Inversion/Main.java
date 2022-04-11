import java.util.*;

class Main {
    public static int inv = 0;
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void inversion(int[] nums, int k) {
        int i = k+1;
        for (i = k+1; i < nums.length; i++) {
            if (nums[k] > nums[i]) {
                // swap(nums, i, k);
                inv++;
            }
        }

    }

    static int countInversion(int[] nums) {
        // int i =1;
        // int k = 0;
        // int i = 0;

        for(int i = 0; i < nums.length; i++){
            inversion(nums, i);
            // System.out.println(Arrays.toString(nums));

        }
        return inv;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 20, 6, 4, 5 };

        // swap(nums, 0, 2);
        System.out.println(countInversion(nums));
        // System.out.println(Arrays.toString(nums));
    }
}
