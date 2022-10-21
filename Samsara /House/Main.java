import java.util.*;

class Main {

    public static int[] sol(int[] houses, int[] queries) {
        // null case
        if (houses == null || houses.length == 0)
            return new int[] {};

        int n = houses.length;
        // maximum house number
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, houses[i]);
        }
        // create a array to place the houses
        // 0-> no house
        // 1-> house
        int[] place = new int[max + 1];
        for (int i = 0; i < n; i++) {
            place[houses[i]] = 1;
        }
        // getting segment numbers
        int count = 0;
        int k = 1;
        while (k <= max) {
            boolean flag = false;
            while (k <= max && place[k] == 1) {
                k++;
                flag = true;
            }
            if (flag) {
                count++;
            }
            k++;
        }
        // go over queries
        int[] result = new int[queries.length];
        int r = 0;
        for (int query : queries) {
            if (place[query - 1] == 0 && place[query + 1] == 0) {
                count--;
            } else if (place[query - 1] == 1 && place[query + 1] == 1) {
                count++;
            }
            place[query] = 0;
            result[r++] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] houses = new int[] { 1, 2, 3, 6, 7, 9, 10, 11 };
        // int[] queries = new int[] { 6, 3, 7, 2, 9, 1 };
        int[] houses = new int[] { 2, 4, 5, 6, 7 };
        int[] queries = new int[] { 5, 6, 2 };
        System.out.println(Arrays.toString(sol(houses, queries)));
    }
}