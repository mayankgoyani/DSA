import java.util.HashMap;

class Main {
    static String secFreq(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            // System.out.println(map.get(arr[i]));

        }
        // System.out.println(map);

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        String result = new String();
        for (String s : map.keySet()) {
            // System.out.println(map.get(s));
            if (map.get(s) > max) {
                secondMax = max;
                max = map.get(s);
                // System.out.println(max + " " + secondMax);
            } else if (map.get(s) > secondMax && map.get(s) != max) {
                secondMax = map.get(s);
                result = s;

            }

        }
        return result;
    }

    public static void main(String[] args) {

        String[] arr = new String[] { "aaa", "bbb", "ccc", "bbb", "aaa", "aaa", "bbb" };
        System.out.println(secFreq(arr, 2));

    }
}