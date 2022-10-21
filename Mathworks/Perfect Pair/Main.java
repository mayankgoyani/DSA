import java.util.Arrays;

class Main {
    private static int sol(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int result = 0;
        // remove the sign from the each nums
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        // sort the array
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int bsI = bsIndex(nums, i + 1, n - 1, 2 * nums[i]);
            if (bsI == n - 1) {
                if (nums[bsI] <= 2 * nums[i]) {
                    result += (bsI - i);
                } else {
                    result += (bsI - 1 - i);
                }
            } else {
                result += (bsI - 1 - i);
            }
        }
        return result;
    }

    private static int bsIndex(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            // if mid elemen is equal to our target element then we return mid index;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                // else if mid element is greater then target that means our target element may
                // be in first half of the array. So,
                r = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        // int[] nums = new int[] {1,2,3,4,5,-6, -9, -1};
        int[] nums = new int[] { -6, 9, 2, 1 };
        System.out.println(sol(nums));
    }
}