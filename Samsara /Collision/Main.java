import java.util.*;

class Main {
    private static int sol(int[][] centers){
        // null case
        if(centers == null || centers.length == 0) return 0;

        // go over all the centers and creata a map of its row and cols
        Map<List<Integer>, Integer> map = new HashMap<>();
        int result = 0;
        int n = centers.length;
        for(int i = 0; i < n; i++){
            int r = centers[i][0];
            int c = centers[i][1];
            List<Integer> key = Arrays.asList(r, c);
            map.put(key,map.getOrDefault(key, 0)+1);
        }
        Map<Integer, List<int[]>> col = new HashMap<>();
        
         for(int i = 0; i < n; i++){
            int r = centers[i][0];
            int c = centers[i][1];
            for(int j = -2; j <=2 ; j++){
                for(int k = -2; k <=2; k++){
                    List<Integer> key = Arrays.asList(r + j, c + k);
                    if(j == 0 && k == 0){
                        if(map.containsKey(key) && map.get(key) > 1){
                            result += map.get(key) - 1;
                        }
                    } else{
                        if(map.containsKey(key)){
                            result += map.get(key);
                        }
                    }
                }
            }
         }

        return result / 2;
    }
    public static void main(String[] args) {
        int[][] centers = new int[][]{
            {1,1},
            {2,2},
            {0,4}
        };
        System.out.println(sol(centers));
    }
}