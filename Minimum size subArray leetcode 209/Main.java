
// Given an array of positive integers nums and a positive integer target,
//  return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
//   of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

class Main {

    static int minSubArray(int[] nums, int target) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        System.out.println(minSubArray(nums, target));

    }
}