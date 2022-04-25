import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Main {
    static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        HashMap<String, List> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[] { "cat", "tac", "eat", "tea" };
        System.out.println(groupAnagrams(strs));
    }
}