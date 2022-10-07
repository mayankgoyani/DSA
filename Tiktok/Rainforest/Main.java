import java.util.*;

class Main {
    public static int ways(List<List<Integer>> forest, int number) {
        int m = forest.size(), n = forest.get(0).size();
        Integer[][][] dp = new Integer[number][m][n];
        int[][] preSum = new int[m + 1][n + 1]; // preSum[r][c] is the total number of apples in pizza[r:][c:]
        for (int r = m - 1; r >= 0; r--)
            for (int c = n - 1; c >= 0; c--)
                preSum[r][c] = preSum[r][c + 1] + preSum[r + 1][c] - preSum[r + 1][c + 1]
                        + (forest.get(r).get(c) == 2 ? 1 : 0);
        System.out.println(Arrays.deepToString(preSum));
        return dfs(m, n, number - 1, 0, 0, dp, preSum);
    }

    private static int dfs(int m, int n, int number, int r, int c, Integer[][][] dp, int[][] preSum) {
        if (preSum[r][c] == 0)
            return 0; // if the remain piece has no apple -> invalid
        if (number == 0)
            return 1; // found valid way after using number-1 cuts
        if (dp[number][r][c] != null)
            return dp[number][r][c];
        int ans = 0;
        // cut in horizontal
        for (int nr = r + 1; nr < m; nr++)
            if (preSum[r][c] - preSum[nr][c] > 0) // cut if the upper piece contains at least one apple
                ans = (ans + dfs(m, n, number - 1, nr, c, dp, preSum)) % 1_000_000_007;
        // cut in vertical
        for (int nc = c + 1; nc < n; nc++)
            if (preSum[r][c] - preSum[r][nc] > 0) // cut if the left piece contains at least one apple
                ans = (ans + dfs(m, n, number - 1, r, nc, dp, preSum)) % 1_000_000_007;
        return dp[number][r][c] = ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(Arrays.asList(1, 2, 3));
        forest.add(Arrays.asList(2, 1, 2));
        forest.add(Arrays.asList(3, 1, 1));
        System.out.println(ways(forest, 3));
    }
}