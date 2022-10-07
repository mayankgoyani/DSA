import java.util.*;
class Main {
    private static int m;
    private static int n;
    final static int mod = 1000000007;
    private static int[][] popular;
    // dp matrix
    private static int[][][] dp;

    // approch using dp matrix
    public static int ways(List<List<Integer>> forest, int number) {
        // null case
        if (forest == null || forest.size() == 0)
            return 0;
        m = forest.size();
        n = forest.get(0).size();
        // dp matrix
        dp = new int[m + 1][n + 1][number + 1];

        // number of popular at the remaining row and remaining col
        popular = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                popular[i][j] = popular[i + 1][j] + popular[i][j + 1]
                        - popular[i + 1][j + 1] + (forest.get(i).get(j) == 2 ? 1 : 0);
            }
        }
        // fill dp array with -1;
        for (int[][] dp1 : dp) {
            for (int[] dp2 : dp1) {
                Arrays.fill(dp2, -1);
            }
        }
        return dfs(0, 0, number - 1);
        // return 0;
    }

    private static int dfs(int row, int col, int number) {

        // base case
        if (dp[row][col][number] != -1) {
            return dp[row][col][number];
        }
        // if there is no cut
        if (number == 0) {
            dp[row][col][number] = (popular[row][col] > 0) ? 1 : 0;
            return dp[row][col][number];
        }

        // main logic
        int rowSum = 0;
        int colSum = 0;
        for (int i = row + 1; i < m; i++) {
            if (popular[row][col] - popular[i][col] > 0 && popular[row][col] >= number) {
                rowSum = (rowSum + dfs(i, col, number - 1)) % mod;
            }
        }

        for (int i = col + 1; i < n; i++) {
            if (popular[row][col] - popular[row][i] > 0 && popular[row][col] >= number) {
                colSum = (colSum + dfs(row, i, number - 1)) % mod;
            }
        }
        dp[row][col][number] = (rowSum + colSum) % mod;
        return dp[row][col][number];
    }

    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(Arrays.asList(1, 2, 3));
        forest.add(Arrays.asList(2, 1, 2));
        forest.add(Arrays.asList(3, 1, 1));
        System.out.println(ways(forest, 3));
    }
}