
import java.util.Arrays;

class Main {
    static int getMinDiff(int[] arr, int k, int n) {
        Arrays.sort(arr);
        int ans = (arr[n - 1] + k) - (arr[0] + k); // Maximum possible height difference

        int tempmax = arr[n - 1] - k; // Maximum element when we
        // subtract k from whole array
        int tempmin = arr[0] + k; // Minimum element when we
                                  // add k to whole array
        int max, min;

        for (int i = 0; i < n - 1; i++) {
            if (tempmax > (arr[i] + k)) {
                max = tempmax;
            } else {
                max = arr[i] + k;
            }
            // System.out.println("max " +max);
            if (tempmin < (arr[i + 1] - k)) {
                min = tempmin;
            } else {
                min = arr[i + 1] - k;
            }
            // System.out.println("min " + min);

            if (ans > (max - min)) {
                ans = max - min;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 6, 3, 4, 7, 2, 10, 3, 2, 1 };
        int k = 5;
        System.out.println(getMinDiff(nums, k, nums.length));

    }
}