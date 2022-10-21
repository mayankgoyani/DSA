import java.util.Arrays;

class Main {
    private static int[][] sol(int[][] matrix, int radius) {
        // null case
        if (matrix == null || matrix.length == 0)
            return new int[][] {};

        int m = matrix.length;
        int n = matrix[0].length;
        // result matrix
        int[][] result = new int[m][n];

        // go over all the elems in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int temp = 0;
                int count = 0;
                for (int k = -radius; k <= radius; k++) {
                    for (int l = -radius; l <= radius; l++) {
                        if (k == 0 && l == 0)
                            continue;
                        int nr = i + k;
                        int nc = j + l;
                        if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                            temp += matrix[nr][nc];
                            count++;
                        }
                    }
                }
                if(count != 0){
                    temp = temp / count;
                    result[i][j] = (matrix[i][j] + temp) / 2;
                } else{
                     result[i][j] = matrix[i][j];
                }
                
                
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 255 }
        };
        int radius = 1;
        System.out.println(Arrays.deepToString(sol(matrix, radius)));
    }
}