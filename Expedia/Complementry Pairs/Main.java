import java.util.*;


class Main {
    // function 1
    public static class Pair {
        String key;
        int value;
        Pair(String key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public static long sol(List<String> strs) {
        // null case
        if (strs == null || strs.size() == 0)
            return 0;
        int n = strs.size();
        long result = 0;
        // map of length and size of the string
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = strs.get(i);
            int key = s.length();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new Pair(s, i));
        }
        for (int i = 0; i < n; i++) {
            String s = strs.get(i);
            if (map.get(s.length() - 1) != null)
                for (Pair st : map.get(s.length() - 1)) {
                    if (st.value > i && isPal(st.key, s))
                        result++;
                }
            if (map.get(s.length()) != null)
                for (Pair st : map.get(s.length())) {
                    if (st.value > i && isPal(st.key, s))
                        result++;

                }
            if (map.get(s.length() + 1) != null)
                for (Pair st : map.get(s.length() + 1)) {
                    if (st.value > i && isPal(st.key, s))
                        result++;

                }
        }

        return result;
    }

    private static boolean isPal(String s1, String s2) {
        System.out.println(s2 + " " + s1);
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int c = s1.charAt(i) - 'a';
            map[c]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int c = s2.charAt(i) - 'a';
            map[c]++;
        }
        int odd = 0;
        // System.out.println(s1 + " " + s2);
        // System.out.println(Arrays.toString(map));
        for (int i = 0; i < 26; i++) {
            if (map[i] % 2 != 0)
                odd++;
            if (odd > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // List<String> strs = Arrays.asList("ball", "all", "call", "bal");
        List<String> strs = Arrays.asList("abc", "abcd", "bc","adc" , "abc");

        System.out.println(sol(strs));
    }
}