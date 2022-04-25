import java.util.Stack;

class Main {
    static int minSwap(String s){
        //efficient solution
        if(s.length() ==0 ) return 0;
        // int count = 0;
        // Stack<Character> stk = new Stack<>();
        int x=0;
        for(int i=0; i <s.length(); i++){
            if(s.charAt(i) == ']'){
                if(x > 0){
                    x--;
                }
                    // else{
                //     count++;
                // }
            } else{
                x++;
            }
        }
        return (x+1)/2;
        // if(s.length() ==0 ) return 0;
        // int count = 0;
        // Stack<Character> stk = new Stack<>();
        // for(int i=0; i <s.length(); i++){
        //     if(s.charAt(i) == ']'){
        //         if(!stk.isEmpty()){
        //             stk.pop();
        //         } else{
        //             count++;
        //         }
        //     } else{
        //         stk.push(s.charAt(i));
        //     }
        // }
        // return (count+1)/2;
    }

    public static void main(String[] args) {

        System.out.println(minSwap("]]][[["));

    }
}