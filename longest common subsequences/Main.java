import java.util.List;

class Main {

    static int max = 0;

    public static void backTrack(int i, StringBuilder dp1, StringBuilder dp2, String text1, String text2) {
        if (i == text1.length()) {
            if (dp1.length() != 0) {
                if (dp1.toString().equals(dp2.toString())) {
                    if (dp1.length() > max) {
                        max = dp1.length();
                    }
                }
            }
            return;
        }
        dp1.append(text1.charAt(i));
        dp2.append(text2.charAt(i));
        backTrack(i + 1, dp1, dp2, text1, text2);
        dp1.deleteCharAt(dp1.length() - 1);
        dp2.deleteCharAt(dp2.length() - 1);

        // backTrack(i + 1, result, dp, s);
        backTrack(i + 1, dp1, dp2, text1, text2);

    }

    static void longestCommonSubsequence(String text1, String text2) {
        backTrack(0, new StringBuilder(), new StringBuilder(), "abcde", "ace");
        System.out.println(max);
    }

    public static void main(String[] args) {
     longestCommonSubsequence("text1", "text2");
    }
}