class Main {
    static int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {

            int left = height[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }

            int right = height[i];
            for (int j = i + 1; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            // System.out.println(left + " " + right);
            res += Math.min(left, right) - height[i];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(nums));
    }
}