class Main {

    static int[] reveseArray(int[] nums){
        int l=0;
        int r = nums.length -1;
        while(l <=r){
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        nums = reveseArray(nums);
        for(int i=0; i < nums.length; i++){
            System.out.print(nums[i]+ ",");
        }
    }
}