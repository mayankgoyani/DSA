import java.util.ArrayList;
import java.util.List;

class Main {

    public static List<Integer> sol(long n, List<List<Integer>> queries) {
        // null case
        if (queries == null)
            return new ArrayList<>();

        List<Long> li = new ArrayList<>();
        long m = 1l;
        while (n > 0) {
            if (n % 2l != 0) {
                li.add(m);
            }
            m *= 2l;
            n = n / 2l;
        }
        System.out.println(li);
        List<Integer> result = new ArrayList<>();
        for (List<Integer> query : queries) {
            long l = query.get(0);
            long r = query.get(1);
            long mod = query.get(2);
            long ans = 1;
            for (long i = l - 1; i <= r - 1; i++) {
                ans = (int) ((ans * li.get((int) i)) % mod);
            }
            // int res =(ans % mod);
            result.add((int)ans);
        }
        return result;
    }

    public static void main(String[] args) {
        long n = 65;
        List<Integer> query = new ArrayList<>();
        List<List<Integer>> queries = new ArrayList<>();
        query.add(1);
        query.add(2);
        query.add(4);
        queries.add(query);
        query = new ArrayList<>();
        query.add(2);
        query.add(2);
        query.add(8);
        queries.add(query);
        query = new ArrayList<>();
        query.add(1);
        query.add(1);
        query.add(4);
        queries.add(query);
        query = new ArrayList<>();
        System.out.println(sol(n, queries));
    }
}