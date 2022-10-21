import java.util.*;

class Main {
    private static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    private static int sol(int min, int max, int ones, int zeros) {
        int temp = Math.min(ones, zeros);
        int range = Math.max(min, temp);
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        map.put(ones, new HashSet<>());
        map.get(ones).add(Arrays.asList(0, 1));
        if (!map.containsKey(zeros)) {
            map.put(zeros, new HashSet<>());
        }
        map.get(zeros).add(Arrays.asList(1, 0));
        for (int i = range; i <= max; i++) {
            if (!map.containsKey(i)) {
                map.put(i, new HashSet<>());
            }
            if (map.containsKey(i - ones) && map.get(i - ones).size() > 0) {
                for (List<Integer> tmp : map.get(i - ones)) {
                    map.get(i).add(Arrays.asList(tmp.get(0), tmp.get(1) + 1));
                }
            }
            if (map.containsKey(i - zeros) && map.get(i - zeros).size() > 0) {
                for (List<Integer> tmp : map.get(i - zeros)) {
                    map.get(i).add(Arrays.asList(tmp.get(0) + 1, tmp.get(1)));
                }
            }
        }
        int result = 0;
        for (int key : map.keySet()) {
            for (List<Integer> tmp : map.get(key)) {
                result += (factorial(tmp.get(0) + tmp.get(1)) / (factorial(tmp.get(0)) * factorial(tmp.get(1))));
            }
        }

        return result;
    }

    public static int sol2(int min, int max, int ones, int zeros) {
        final int mod = 1000000007;
        int m = max / ones;
        int n = max / zeros;
        // dp array
        int[][] dp = new int[m + 1][n + 1];
        int result = 0;

        for(int i = 1; i <= m;i++){
            dp[i][0] = 1;
            result += dp[i][0];
        }
        for(int j = 1; j <=n; j++){
            dp[0][j] = 1;
            result += dp[0][j];
        }
        for(int i = 1; i <=m; i++){
            for(int j = 1; j <= n; j++){
                if((i * ones + j * zeros) <= max){
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
                    result = (result + dp[i][j]) % mod;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int min = 2;
        int max = 10;
        int ones = 3;
        int zeros = 2;
        // System.out.println(sol(min, max, ones, zeros));
        System.out.println(sol2(min, max, ones, zeros));

    }
}