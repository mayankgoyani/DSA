import java.util.Arrays;

class Main {

    public static void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void threeWayPartition(int nums[], int a, int b) {

        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < a) {
                swap(nums, i, x);
                x++;
            }
            // System.out.println(x);

        }
        for (int i = x; i < nums.length; i++) {
            if (nums[i] >= a && nums[i] <= b) {
                swap(nums, i, x);
                x++;
            }
        }
        for (int i = x; i < nums.length; i++) {
            if (nums[i] >= a && nums[i] <= b) {
                swap(nums, i, x);
                x++;
            }
        }
        // System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 1, 3, 3, 4 };
        threeWayPartition(nums, 2, 3);
        System.out.println(Arrays.toString(nums));
    }
}