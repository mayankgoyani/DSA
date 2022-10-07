import java.util.*;

class Main {

    private static int sol(List<Integer> cost, List<Integer> time) {
        int n = cost.size();
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = cost.get(i);
            pair[i][1] = time.get(i);
        }

        Arrays.sort(pair, (a, b) -> b[1] - a[1]);

        // max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            return b[0] - a[0];
        });
        int result = Integer.MAX_VALUE;
        int k = 0;
        int cst = 0;
        for(int i = 0; i < n; i++){
            k += pair[i][1] + 1;
            cst += pair[i][0];
            pq.add(pair[i]);
            if(k >= n){
                result = Math.min(result, cst);
            }
            while(k >= n){
                if(pq.isEmpty()){
                     k = 0;
                } else{
                    int[] temp = pq.poll();
                    k -= (temp[1] + 1);
                    cst -= temp[0];
                }
                
            }
            
        }
        return result;

    }

    public static void main(String[] args) {
        List<Integer> cost = new ArrayList<>();
        List<Integer> time = new ArrayList<>();
        cost.add(1);
        cost.add(1);
        cost.add(3);
        cost.add(4);
        time.add(3);
        time.add(1);
        time.add(2);
        time.add(3);
        System.out.println(sol(cost, time));

    }
}