class Main {
    public static int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 0, j = nums.length - 1; i <= j;) {
            if (nums[i] == nums[j]) {
                i++;
                j--;
            } else if (nums[i] > nums[j]) {
                j--;
                nums[j] += nums[j + 1];
                ans++;
            } else {
                i++;
                nums[i] += nums[i - 1];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 1 };
        System.out.println(minOperations(nums));
    }

}
