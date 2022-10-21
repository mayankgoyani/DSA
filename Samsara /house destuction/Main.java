import java.util.*;

class Main {
    private static int[] parent;
    public static void UnionFind(int size){
        parent = new int[size];
        for(int i = 0; i< size; i++){
            parent[i] = i;
        }
    }

    public static int find(int x){
        if(x == parent[x]){
            return x;
        } 
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        int pX = find(x);
        int pY = find(y);
        if(pX != pY){
            parent[pY] = pX;
        }
    }

    public static int[] sol(int[] houses, int[] queries){
        // null case
        if(houses == null || houses.length == 0) return new int[]{};

        // go over all the houses and check if is conntected to previous house
        Arrays.sort(houses);
        int n = houses.length;
        UnionFind(houses[n-1] + 1);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i < n; i++){
            if(houses[i-1] + 1 == houses[i]){
                union(houses[i-1], houses[i]);
            }
        }
        for(int i = 0; i < n; i++){
            int p = find(houses[i]);
            map.put(p, map.getOrDefault(p, 0)+1);
        }
        int[] result = new int[queries.length];
        int r = 0;
        for(int query : queries){
            int p = parent[query];
            if(map.containsKey(p)){
                map.put(p, map.get(p) - 1);
                map.remove(p,0);
            }
            result[r++] =  map.size();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] houses = new int[]{1,2,3,6,7,9};
        int[] queries = new int[]{6,3,7,2,9,1};
        System.out.println(Arrays.toString(sol(houses, queries)));
    }
}