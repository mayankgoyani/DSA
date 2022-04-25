import java.util.ArrayList;
import java.util.List;

class Main {

    static void backTrack(int ind, String s, List<String> result, StringBuilder sb) {

    }

    static List<String> restoreIp(String s) {
        List<String> result = new ArrayList<>();
        backTrack(0, s, result, new StringBuilder());
        return result;
    }

    public static void main(String[] args) {

    }
}