import java.util.*;

class Main {

    static long findMinDiff(ArrayList<Long> a, long m) {

        long result = 0L;
        long min = Long.MAX_VALUE;
        Collections.sort(a);
        for (int i = 0; i < a.size() - m + 1; i++) {
            min = Math.min(a.get((int) m + i - 1) - a.get(i), min);
        }
        return min;
    }

    public static void main(String[] args) {

        ArrayList<Long> a = new ArrayList<Long>();
        a.add((long) 3);
        a.add((long) 4);
        a.add((long) 9);
        a.add((long) 1);
        a.add((long) 56);
        a.add((long) 7);
        a.add((long) 9);
        a.add((long) 12);
        long k = 5L;
        System.out.println(findMinDiff(a, k));

    }
}