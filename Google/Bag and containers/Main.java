
import java.util.*;

class Main {
    public static int[] sol(int[] bags, int size){
        // null case
        if(bags == null || bags.length  == 0) return new int[]{};
        // list to store max bags in containers
        List<Integer> li = new ArrayList<>();

        int k = 0;
        int currCont = 0;
        // go over all the bags and if container size is less then 
        // total bag add new container
        for(int i = 0; i < bags.length; i++){
            currCont += bags[i];
            if (currCont > size) {
                li.add(k);
                k = 0;
                currCont = bags[i];
            }
            k++;
        }
        li.add(k);
        System.out.println(li);
        // result array 
        int[] result = new int[bags.length];

        // pointer for get result array

        int i = 0;
        // pointer for maintain the container
        int n = bags.length -1;
        // pointer for maintain pop element from
        // bag size
        int lp = li.size() - 1;
        while(i < bags.length){
            // System.out.println(n);
            for(int j = n; j < n + li.get(lp); j++){
                    result[i++] = bags[j];
            }
            if(i == bags.length) break;
            lp--;
            n = n - li.get(lp);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] bags = new int[] {2,25,30,15,12,3,12};
        int size = 35;
        System.out.println(Arrays.toString(sol(bags, size)));
    }
}