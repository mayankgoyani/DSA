import java.util.HashMap;

class Main {
    static int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(k - nums[i])) {
                count += m.get(k - nums[i]);
            }
            // if (m.containsKey(nums[i])) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            // } else {
            // m.put(nums[i], 1);
            // }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 5, 7, -1, 5 };

        System.out.print("Count of pairs is "
                + findPairs(nums, 6));
    }
}