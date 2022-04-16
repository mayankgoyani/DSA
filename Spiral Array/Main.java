import java.util.ArrayList;

class Main {
    public static ArrayList<Integer> spiral(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int up = 0;
        int down = row - 1;
        int left = 0;
        int right = col - 1;

        while (result.size() < row * col) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            for (int i = right - 1; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            for (int i = down - 1; i > up; i--) {
                result.add(matrix[i][left]);
            }
            up++;
            down--;
            left++;
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println(spiral(matrix));
    }
}