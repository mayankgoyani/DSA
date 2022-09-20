import javax.swing.text.html.StyleSheet;

class Main {

    private static int countPalindrome(String  s){
        // null case
        if(s == null || s.length() == 0) return 0;
        int n  = s.length();
        int[][] dp = new int[n+1][n+1];
        
        return dp[n][n];
    }
    public static void main(String[] args) {
        
    }
}