
public class Main {
    static int trap(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (l <= r) {
            if (height[l] <= height[r]) {
                if (height[l] >= leftMax)
                    leftMax = height[l];
                else
                    ans += leftMax - height[l];
                l++;

            } else {
                if (height[r] >= rightMax)
                    rightMax = height[r];
                else
                    ans += rightMax - height[r];
                r--;
            }

        }
        // System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
        // System.out.println("x");
    }
}