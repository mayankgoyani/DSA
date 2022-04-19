import java.util.ArrayList;
import java.util.HashSet;

class Main {

    public static ArrayList<Integer> commonElements(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int j = 0; j < matrix[0].length; j++) {
            set.add(matrix[0][j]);
        }
        // System.out.println(set);

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> set2 = new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {
                // System.out.print(matrix[i][j] + " ");
                if (set.contains(matrix[i][j])) {
                    // System.out.println(matrix[i][j]);
                    set2.add(matrix[i][j]);
                }
            }
            set = new HashSet<>(set2);
            // System.out.println();
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1, 2, 1, 4, 8 },
                { 3, 7, 8, 5, 1 },
                { 8, 7, 7, 3, 1 },
                { 8, 1, 2, 7, 9 }
        };

        System.out.println(commonElements(matrix));

    }
}