import java.util.Arrays;
import java.util.List;

class Main {
    private static long sol(List<Integer> nums, int k) {
        // nll case
        if (nums == null || nums.size() == 0)
            return 0;
        int n = nums.size();
        long count = 0;
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums.get(j + 1) > nums.get(j)) {
                    nums.set(j + 1, nums.get(j + 1) + nums.get(j));
                    nums.set(j, nums.get(j + 1) - nums.get(j));
                    nums.set(j + 1, nums.get(j + 1) - nums.get(j));
                    System.out.println(nums);
                }
            }
        }
        System.out.println(nums);
        for (int i = 0; i < n; i++) {
            if (count == k)
                return sum;
            else {
                sum += nums.get(i);
                count++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // List<Integer> nums = Arrays.asList(4, 6, -10, -1, 10, -20);
        List<Integer> nums = Arrays.asList(1,4,1,5,6,7,3,1);

        System.out.println(sol(nums, 4));
    }
}