import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Java Code to find elements whose
// frequency yis more than n/k
class Main {
    static List<Integer> moreThanNdk(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int x = nums.length / k;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 1) + 1);
        }

        for (Map.Entry m : map.entrySet()) {
            Integer temp = (Integer) m.getValue();
            if (temp > x) {
                result.add((Integer) m.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 2, 2, 3, 5, 4, 2, 2, 3, 1, 1, 1 };
        int k = 4;
        moreThanNdk(nums, k).forEach(value -> System.out.println(value));
    }
}