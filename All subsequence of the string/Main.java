import java.util.ArrayList;
import java.util.List;

class Main {

    public static void backTrack(int i, List<String> result, StringBuilder dp, String s) {
        if (i == s.length()) {
            if(dp.length() != 0){
                result.add(dp.toString());
            }
            
            return;
        }
        dp.append(s.charAt(i));
        backTrack(i + 1, result, dp, s);
        dp.deleteCharAt(dp.length() - 1);
        backTrack(i + 1, result, dp, s);

    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        backTrack(0, result, new StringBuilder(), "abcd");
        System.out.println(result);
    }
}