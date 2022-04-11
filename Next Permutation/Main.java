import java.util.*;

class Main {
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }

    static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i])
            i--;
        if (i >= 0) {
            int j = nums.length -1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        nextPermutation(nums);
        // swap(nums, 0, 2);
        System.out.println(Arrays.toString(nums));
    }
}
