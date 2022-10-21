import java.util.*;

class Main {
    private static int sol(List<Integer> li, int k) {
        // create a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int elem : li) {
            pq.add(elem);
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            int max = pq.poll();
            result += max;
            max = (int) Math.ceil((double) max / 3);
            pq.add(max);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(20, 4, 3, 1, 9);
        int  k = 4;
        System.out.println(sol(li, k));
    }
}