import java.util.*;

class Main {

    public static int sol(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return 0;
        // create a map of length and same length
        // numbers
        int n = nums.length;
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // convert into the string
            String str = String.valueOf(nums[i]);
            int len = str.length();
            // length of the string
            if (!map.containsKey(len)) {
                map.put(len, new ArrayList<>());
            }
            map.get(len).add(str);
        }

        int result = 0;
        // go over all the lengths and make a pair and check
        // if it valid or not
        for (int key : map.keySet()) {
            List<String> li = map.get(key);
            int size = li.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (isValid(li.get(i), li.get(j))) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    // valid pair function
    private static boolean isValid(String x, String y) {
        int count = 0;
        // for (int i = 0; i < x.length(); i++) {
        // if (x.charAt(i) != y.charAt(i)) {
        // count++;
        // }
        // }
        // for shuffling
        char[] ch1 = x.toCharArray();
        char[] ch2 = y.toCharArray();
        // Arrays.sort(ch1);
        // Arrays.sort(ch2);

        for (int i = 0; i < x.length(); i++) {
            if (ch1[i] != ch2[i]) {
                count++;
            }
        }

        return count == 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 25, 20, 15, 10, 5, 1 };
        System.out.println(sol(nums));
    }
}
