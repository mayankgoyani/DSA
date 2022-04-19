class Main {

    public static int maxCount(int[] nums) {
        int l = 0;
        int r = 0;
        int zeros = 0;
        int max = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                zeros++;
            }
            while (zeros > 1) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,0,1,1,1,0,1,1,1};
        System.out.print(maxCount(nums));

    }
}