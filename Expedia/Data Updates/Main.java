import java.util.*;

class Main {
    public static List<Integer> sol(List<Integer> data, List<List<Integer>> updates) {
        // null case
        if (data == null || data.size() == 0) {
            return new ArrayList<>();
        }
       
        // final list
        Map<List<Integer>, Integer> map = new HashMap<>();
        int n = updates.size();
        List<Integer> curr = new ArrayList<>(updates.get(0));
        for (int i = 1; i < n; i++) {
            List<Integer> temp = updates.get(i);
            if (curr.get(1) >= temp.get(0)) {
                li.add(Arrays.asList(curr.get(0), temp.get(1) -1));

            }
        }
        System.out.println(li);

        for (int i = 0; i < n; i++) {
            int l = updates.get(i).get(0) - 1;
            int r = updates.get(i).get(1) - 1;
            for (int j = l; j <= r && j >= 0; j++) {
                data.set(j, data.get(j) * -1);
            }
        }
        return data;
    }

    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(3, 1, 3, 0, 7);
        List<List<Integer>> updates = new ArrayList<>();
        updates.add(Arrays.asList(1, 4));
        updates.add(Arrays.asList(3, 5));
        updates.add(Arrays.asList(1, 3));
        updates.add(Arrays.asList(3, 5));
        updates.add(Arrays.asList(2, 3));
        System.out.println(sol(data, updates));

    }
}