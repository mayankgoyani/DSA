class Main {
    public static int minSwap(int[] nums, int k) {
        int good = 0;
        int bad = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= k)
                good++;
        }
        for (int i = 0; i < good; i++) {
            if (nums[i] > k)
                bad++;
        }
        int ans = bad;

        for (int i = 0, j = good; j < nums.length; i++, j++) {
            if (nums[i] > k)
                bad--;
            if (nums[j] > k)
                bad++;
            ans = Math.min(ans, bad);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 1, 5, 6, 3 };
        int k = 3;
        System.out.println(minSwap(nums, k));
        int arr1[] = { 2, 7, 9, 5, 8, 7, 4 };
        k = 5;
        System.out.println(minSwap(arr1, k));

    }
}