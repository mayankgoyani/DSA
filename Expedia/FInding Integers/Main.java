import java.util.*;

class Main {

    public static List<Integer> sol(List<Integer> arr , int k){
        // null case
        if(arr == null || arr.size() == 0) return new ArrayList<>();

        // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // result list
        List<Integer> result = new ArrayList<>();
        int n = arr.size();
        for(int i = 0; i < n; i++){
            pq.add(arr.get(i));
            if(pq.size() >= k){
                if(pq.size() == k){
                    result.add(pq.peek());
                } else{
                    pq.poll();
                    result.add(pq.peek());
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3,2,4,5,1);
        System.out.println(sol(arr, 4));
    }
}