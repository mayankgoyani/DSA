import java.util.*;
// import java.lang.*;

class Main {
    static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hs1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hs1.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        int[] result = new int[res.size()];
        int i = 0;
        for (Integer k : res) {
            result[i++] = k;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 2, 1 };
        int[] nums2 = new int[] { 2, 2 };
        
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}