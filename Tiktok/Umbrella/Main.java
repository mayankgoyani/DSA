import java.util.List;
import java.util.*;

class Main {

    private static int umbreallas(List<Integer> sizes , int req){
        // null case
        if(sizes == null ||sizes.size() == 0){
            return -1;
        }
        int n = sizes.size();
        int[][] dp = new int[n + 1][req+1];
        int max = 99999;
        for (int i = 1; i <= req; i++) {
            dp[0][i] = max;
        }
        // go over dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= req; j++) {
                if (j < sizes.get(i - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - sizes.get(i - 1)] + 1);
                }
            }
        }
        return dp[n][req] == 99999 ? -1 : dp[n][req];
    }
    public static void main(String[] args) {
        System.out.println(umbreallas(Arrays.asList(3,5), 7));
    }
}