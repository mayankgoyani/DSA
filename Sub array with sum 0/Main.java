import java.util.HashMap;

class Main {
    static boolean subArray(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                return true;
            } else {
                // System.out.println(sum + " " + nums[i]);
                map.put(sum, nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 2, -3, 1, 6 };
        System.out.println(subArray(nums));
    }
}