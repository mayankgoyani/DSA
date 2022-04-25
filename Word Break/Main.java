import java.util.ArrayList;

class Main {
    static boolean workBreak(String s, ArrayList<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i=0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        ArrayList<String> wordDict = new ArrayList<>();

        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(workBreak("leetcode", wordDict));
    }
}