import java.util.*;

class Main {
    static int[] moveNegatives(int[] nums) {
        int j =0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] < 0){
                if(i != j){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -1, 2, 3, 5, 7, -3, -6, 0 };
        nums = moveNegatives(nums);
        System.out.println(Arrays.toString(nums));
    }
}
