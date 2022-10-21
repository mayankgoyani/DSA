import java.util.*;

class Main {
    private static boolean[] sol(int[][] rectangles) {
        // null case
        if (rectangles == null || rectangles.length == 0)
            return new boolean[] {};

        int maxW = 0;
        int maxH = 0;
        List<Boolean> li = new ArrayList<>();
        // go over all the inputs and if rec[0] =0 update the max width
        // and max height
        for (int[] rec : rectangles) {
            if (rec[0] == 0) {
                maxW = Math.max(maxW, rec[1]);
                maxH = Math.max(maxH, rec[2]);
            } else {
                // check if it fit inside or not
                li.add((maxW <= rec[1] && maxH <= rec[2]) || (maxH <= rec[1] && maxW <= rec[2]));
            }
        }
        // conver li to array
        int n = li.size();
        boolean[] result = new boolean[n];
        for (int i = 0; i < n; i++) {
            result[i] = li.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        // int[][] rectangles = new int[][]{
        // {1,22,1},
        // {0,19,7},
        // {0,11,17},
        // {1,6,43}
        // };

        int[][] rectangles = new int[][] {
                { 1, 22, 20 },
                { 1, 29, 5 },
                { 1, 18, 18 },
                { 0, 6, 6 },
                { 0, 30, 4 },
                { 1, 9, 25 },
                { 1, 28, 12 },
                { 0, 4, 20 },
                { 0, 17, 7 },
                { 0, 6, 6 },
                { 0, 4, 10 },
                { 0, 26, 11 },
                { 1, 26, 15 },
                { 1, 4, 22 },
                { 0, 4, 15 }
        };
        System.out.println(Arrays.toString(sol(rectangles)));
    }
}