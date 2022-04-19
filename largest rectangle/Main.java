import java.util.Arrays;
import java.util.Stack;

class Main {

    public static int maxHistogram(int[] arr) {

        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }

            if (stk.empty())
                leftSmall[i] = 0;
            else
                leftSmall[i] = stk.peek() + 1;
            stk.push(i);
        }

        while (!stk.isEmpty())
            stk.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }

            if (stk.isEmpty())
                rightSmall[i] = n - 1;
            else
                rightSmall[i] = stk.peek() - 1;
            stk.push(i);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return max;
    }

    public static int largestRectangle(int[][] matrix) {
        // int max = 0;
        int[] current = new int[matrix[0].length];
        int max = maxHistogram(current);
        int result = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    current[j] += 1;
                } else {
                    current[j] = 0;
                }
            }
            // System.out.print(Arrays.toString(current));
            max = maxHistogram(current);
            // System.out.println(max);
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 }
        };

        System.out.println(largestRectangle(matrix));
    }
}
