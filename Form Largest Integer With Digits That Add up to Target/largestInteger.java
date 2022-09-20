class Main {


    // approch 1 recursion
    private static int result = 0;

    public static String largestNumber1(int[] cost, int target) {
        // null case
        if (target == 0)
            return "";
        helper(cost, new StringBuilder(), target, 0);
        return String.valueOf(result);

    }

    private static void helper(int[] cost, StringBuilder sb, int target, int sum) {
        // base case
        if (sum >= target) {
            if (sum == target) {
                result = Math.max(result, Integer.parseInt(sb.toString()));
            }
            return;
        }

        // main logic
        for (int i = 0; i < cost.length; i++) {
            // action
            int len = sb.length();
            sb.append(i + 1);
            // recurse
            helper(cost, sb, target, sum + cost[i]);
            // backtrack
            sb.setLength(len);
        }
    }

    // approch 2 using dp
    public static String largestNumber2(int[] cost, int target) {
        // null case
        if (target == 0)
            return "0";
        int n = cost.length;
        // dp matrix
        String[][] dp = new String[n + 1][target + 1];
        for (int i = 1; i <= target; i++) {
            dp[0][i] = "-1";
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = "0";
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < cost[i - 1]) {
                    // if j less then target get from the previous
                    // row
                    dp[i][j] = dp[i - 1][j];
                } else {
                    String prev = dp[i][j - cost[i - 1]];
                    // else we check if current target - cost
                    // is -1 get from the previous row
                    if (prev.equals("-1")) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // else get maximum between previous
                        // row and current row + (i +1);
                        String s1 = dp[i - 1][j];
                        // current row prev string
                        String s2 = prev.equals("0") ? Integer.toString(i) : i + prev;
                        dp[i][j] = max(s1, s2);
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[n][target].equals("-1") ? "0" : dp[n][target];

    }

    private static String max(String s1, String s2) {
        if (s1.equals("-1"))
            return s2;
        if (s1.length() > s2.length())
            return s1;
        if (s2.length() > s1.length())
            return s2;

        // check all chars in the string whenever
        // we get larger char return that string
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) > s2.charAt(i))
                return s1;
            if (s2.charAt(i) > s1.charAt(i))
                return s2;

        }
        return s1;

    }
    public static void main(String[] args) {
        int[] cost = new int[] {4,3,2,5,6,7,2,5,5};
        int target = 9;
        System.out.println(largestNumber1(cost, target));
        System.out.println(largestNumber2(cost, target));
    }
}