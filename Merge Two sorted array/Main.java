import java.util.Arrays;

class Main {
    static int[] mergeArray(int[] nums1, int[] nums2, int m, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {
            if (p2 < 0)
                break;
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1--];
            } else {
                nums1[i] = nums2[p2--];
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 3, 4, 0, 0, 0 };
        int[] nums2 = new int[] { 2, 5, 6 };

        System.out.println(Arrays.toString(mergeArray(nums1, nums2, 3, 3)));
    }
}