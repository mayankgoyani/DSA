
import java.util.Arrays;

class Main {
    static int[][] maxSubArray(int[][] intervals) {
        Arrays.sort(intervals, (val1, val2) -> Integer.compare(val1[0], val2[0]));
        int k = 0;
        int[] prevRange = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if (prevRange[1] > intervals[i][0]) {
                prevRange[1] = prevRange[1] > intervals[i][1] ? prevRange[1] : intervals[i][1];
            } else {
                intervals[k++] = prevRange;
                prevRange = intervals[i];
            }

        }
        intervals[k++] = prevRange;
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++)
            result[i] = intervals[i];
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
        intervals = maxSubArray(intervals);
        // merge Intervals
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(Arrays.toString(intervals[i]));
        }
    }
}