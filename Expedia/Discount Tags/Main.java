import java.util.*;

class Main {
    public static int sol(List<Integer> val){
        // null case
        if(val == null || val.size() == 0) return 0;

        // result sum
        int result = 0;
        //  odds
        List<Integer> odds = new ArrayList<>();

        for(int v : val){
            if(v >= 0){
                if(v % 2 == 0) result += v;
                else {
                    odds.add(v);
                }
            } else {
                if(v % 2 != 0){
                    odds.add(v);
                }
            }
        }
        // System.out.println(odds);
        Collections.sort(odds, Collections.reverseOrder());
        for(int i = 0; i< odds.size() - 1; i+=2){
            if(odds.get(i) + odds.get(i+1) > 0){
                result += odds.get(i) + odds.get(i+1);
            }

        }
        return result;
    } 
    public static void main(String[] args) {
        // List<Integer> val = Arrays.asList(2,3,6,-5,10,1,1);
        // List<Integer> val = Arrays.asList(-1,-2,-3,8,7);
        List<Integer> val = Arrays.asList(6,3,4,-1,9,17);

        System.out.println(sol(val));
    }
}