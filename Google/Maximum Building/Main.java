class Main {
    private static int bNum;

    public static int sol(int[] b, int ropes, int bricks){
        // null case
        if(b == null || b.length == 0) return 0;
        bNum = 0;
        // approch using recursion try all 
        // posibilities
        helper(0, b, ropes, bricks);
        return bNum;


    }

    private static void helper(int ind, int[] b, int ropes, int bricks) {
        // base case
        if(ind == b.length - 1){
            bNum = Math.max(bNum, ind);
            return;
        }

        // main logic
        // case 1 next building's height is
        // less then current buildings height
        if (b[ind] >= b[ind + 1]) {
            helper(ind + 1, b, ropes, bricks);
        }
        // case 2 use rope
        else {
            if (ropes != 0) {
                helper(ind + 1, b, ropes - 1, bricks);
            }
            // case 3 use bricks
            if(bricks >= (b[ind + 1] - b[ind])){
                helper(ind + 1, b, ropes, bricks - (b[ind + 1] - b[ind]));
            }
            
        } 
        
        bNum = Math.max(bNum, ind);
    }

    public static void main(String[] args) {
        int[] b = new int[] {10,50,100,100,100,100,110,200, 250,250, 140,100};
        int ropes = 2;
        int bricks = 100;
        System.out.println(sol(b, ropes, bricks));
    }
}