import java.util.*;

class Main {

    static boolean isSubSet(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int nums : nums1) {
            set.add(nums);
        }
        for (int nums : nums2) {
            if (!set.contains(nums))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 11, 1, 13, 21, 3, 7 };
        int[] nums2 = new int[] { 11, 3, 7, 1,6 };
        System.out.println(isSubSet(nums1, nums2));
        
    }
}