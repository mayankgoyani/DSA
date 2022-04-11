import java.util.Arrays;

class Main {
    static int firstPositive(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] >= 0)
                return i;
        }
        return -1;
    }

    static int firstNegative(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] < 0)
                return i;
        }
        return -1;
    }
    static void rightRotate(int[] nums, int start, int end){
        int tmp = nums[end];
        for (int i = end; i > start; i--)
            nums[i] = nums[i - 1];
        nums[start] = tmp;
    }

    

    static void reArrange(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] >= 0) {
                    int firstNegative = firstNegative(nums, i + 1);
                    // System.out.println(i+1 + " N "+ firstNegative);
                    if (firstNegative != -1) {
                        rightRotate(nums, i + 1, firstNegative);
                        // System.out.println(Arrays.toString(nums));
                    } else break;
                    
                }
            } else {
                if (nums[i] < 0) {
                    int firstPositive = firstPositive(nums, i + 1);
                    // System.out.println(i+1 + " P "+ firstPositive);
                    if (firstPositive != -1) {
                        rightRotate(nums, i + 1, firstPositive);
                    } else break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -5, 5, -2, 2, -8, 4, 7, 1, 8, 0 };
        reArrange(nums);
        System.out.println(Arrays.toString(nums));
    }
}