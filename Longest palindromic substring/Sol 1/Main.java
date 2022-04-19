class Main {
    public static String longestPalindromicSubstrinString(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0, k = i; k < s.length(); j++, k++) {
                if (i == 0) {
                    dp[j][k] = true;
                } else if (i == 1) {
                    dp[j][k] = s.charAt(j) == s.charAt(k);
                } else {
                    if (s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1]) {
                        dp[j][k] = true;
                    } else {
                        dp[j][k] = false;
                    }

                }
                if (dp[j][k]) {
                    start = j;
                    end = k;
                }

            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstrinString("babad"));
    }
}