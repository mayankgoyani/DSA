class Main {
    static int maxSubArray(int[] nums) {
        int currentSubArray = nums[0];
        int maxSubArray = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSubArray = Math.max(nums[i], nums[i] + currentSubArray);
            maxSubArray = Math.max(currentSubArray, maxSubArray);

        }
        return maxSubArray;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };


        //kadane's algorithm
        System.out.println(maxSubArray(nums));
    }
}