class Main {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i + 1;
            } else {
                max = Math.max(max, i - j + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = new int[] { 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnes(nums));

    }
}