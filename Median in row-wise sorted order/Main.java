class Main {
    public static int binarySearch(int[] mat, int med) {
        int l = 0;
        int r = mat.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mat[mid] <= med)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

    public static int median(int[][] matrix) {

        int l = Integer.MIN_VALUE;
        int r = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 0; i < matrix.length; i++) {
                count += binarySearch(matrix[i], mid);
            }
            if (count <= (matrix.length * matrix[0].length / 2)) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 }
        };

        System.out.println(median(matrix));

    }
}