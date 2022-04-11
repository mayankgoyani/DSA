class Main {

    static int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            max = Math.max(prices[i] - minPrice, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        int result = maxProfit(prices);
        System.out.println("maxProfit = " + result);
    }
}