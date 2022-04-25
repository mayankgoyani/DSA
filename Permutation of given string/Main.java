import java.util.ArrayList;
import java.util.List;

class Main {

    public static void backTrack(List<String> result, StringBuilder dp, String s, boolean[] visited) {
        if (dp.length() == s.length()) {
                result.add(dp.toString());
            return;
        }
        for (int j = 0; j < s.length(); j++) {
            if (!visited[j]) {
                visited[j] = true;
                dp.append(s.charAt(j));
                backTrack(result, dp, s, visited);
                dp.deleteCharAt(dp.length() - 1);
                visited[j] = false;
            }
            // backTrack(i + 1, result, dp, s);
        }

    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[3];
        backTrack(result, new StringBuilder(), "abc", visited);
        System.out.println(result);
    }
}