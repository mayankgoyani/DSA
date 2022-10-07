import java.util.*;

class Main {
    private static boolean sol(String a, String b) {
        String[] aArr = a.split(" ");
        String[] bArr = b.split(" ");
        // check if both elements are equal then we dont have to worry
        // to store the indexex
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < aArr.length; i++) {
            String ai = aArr[i];
            String bi = bArr[i];
            if (!ai.equals(bi)) {
                indexes.add(i);
            }
        }
        // create a map of remaining elements
        Map<Integer, Integer> map = new HashMap<>();
        for (int ind : indexes) {
            int key = Integer.parseInt(aArr[ind]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int ind : indexes) {
            int key = Integer.parseInt(bArr[ind]);
            System.out.println(map);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) - 1);
                map.remove(key, 0);
            } else if (map.containsKey(key - 1)) {
                map.put(key - 1, map.get(key - 1) - 1);
                map.remove(key - 1, 0);
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean sol2(String a, String b) {
        String[] ar = a.split(" ");
        String[] br = b.split(" ");
        int n = ar.length;
        List<Integer> als = new ArrayList<>();
        List<Integer> bls = new ArrayList<>();

        for (String s : ar)
            als.add(Integer.parseInt(s));
        for (String s : br)
            bls.add(Integer.parseInt(s));

        
        Collections.sort(als);
        Collections.sort(bls);

        for (int i = 0; i < n; i++) {
        if (als.get(i) == bls.get(i) || als.get(i) + 1 == bls.get(i))
        continue;
        else
        return false;
        }

        return true;

    }

    public static void main(String[] args) {
        String a = "1 2 3 4 0 5 4 1 6";
        String b = "1 2 3 4 1 6 2 5 5";
        System.out.println(sol(a, b));
        System.out.println(sol2(a, b));
    }
}