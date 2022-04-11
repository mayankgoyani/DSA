class Main {
    static int minJump(int[] nums) {

        int jumps = 0, currentJumpEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // we continuously find the how far we can reach in the current jump
            farthest = Math.max(farthest, i + nums[i]);
            // System.out.print("f"+farthest);
            // System.out.print("c"+currentJumpEnd);
            System.out.println();


            // if we have come to the end of the current jump,
            // we need to make another jump
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        if (currentJumpEnd < nums.length - 1)
            return -1;
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 5, 2, 1, 4, 1, 6, 2 };
        System.out.println(minJump(nums));
    }
}