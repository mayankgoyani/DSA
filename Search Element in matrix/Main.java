import java.lang.annotation.Target;

class Main {

    public static boolean binarySearch(int[] mat, int target) {

        int l = 0;
        int r = mat.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mat[mid] > target)
                r = mid - 1;
            else if (mat[mid] < target)
                l = mid + 1;
            else
                return true;
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            int first = matrix[i][0];
            int last = matrix[i][matrix[0].length - 1];
            if (target == first && target == last)
                return true;
            else if (target > first && target < last) {
                return binarySearch(matrix[i], target);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };

        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }
}