class Main{
    static int findDuplicate(int[] nums){
        boolean[] visited = new boolean[nums.length];
        for(int i=0; i< nums.length; i++){
            if(visited[nums[i]]){
                return nums[i];
            }
            visited[nums[i]] = true;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}