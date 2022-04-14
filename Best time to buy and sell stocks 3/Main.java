class Main {
    static int maxProfit(int[] nums) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int i = 0; i < nums.length; i++) {

            firstBuy = Math.max(firstBuy, -nums[i]);
            firstSell = Math.max(firstSell, firstBuy + nums[i]);
            secondBuy = Math.max(secondBuy, firstSell - nums[i]);
            secondSell = Math.max(secondSell, secondBuy + nums[i]);

        }
        return secondSell;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(maxProfit(nums));
    }
}