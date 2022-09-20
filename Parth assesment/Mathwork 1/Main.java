import java.util.*;

class Main {
    public static List<Integer> sol(List<Integer> numCars, List<Integer> hourStart) {

        // null case
        if(numCars == null || numCars.size() == 0) return new ArrayList<>();

        // mao for count of the maxCars
        Map<Integer, Integer> map = new HashMap<>();
        int n = numCars.size();
        // freq of the maxCars
        int[] maxFreq = new int[n];
        // maxCars
        int max = numCars.get(n-1);
        for(int i = n-1; i >=0; i--){
            // count of maxCars
            map.put(numCars.get(i), map.getOrDefault(numCars.get(i), 0)+1);
            // update maxCars
            max = Math.max(max, numCars.get(i));
            // update the frequency
            maxFreq[i] = map.get(max);
        }
        int h = hourStart.size();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < h; i++){
            result.add(maxFreq[hourStart.get(i) - 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numCars = new ArrayList<>();
        List<Integer> hourStart = new ArrayList<>();
        // numCars.add(5);
        // numCars.add(4);
        // numCars.add(5);
        // numCars.add(3);
        // numCars.add(2);
        // hourStart.add(1);
        // hourStart.add(2);
        // hourStart.add(4);
        // hourStart.add(5);
        numCars.add(2);
        numCars.add(1);
        numCars.add(2);
        hourStart.add(1);
        hourStart.add(2);
        hourStart.add(3);
        System.out.println(sol(numCars, hourStart));

    }
}