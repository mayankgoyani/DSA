import java.util.HashSet;
import java.util.Set;

class Main {
    static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int ls = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int cs = 1;
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    cs += 1;

                }
                ls = Math.max(ls, cs);
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive(nums));
    }
}