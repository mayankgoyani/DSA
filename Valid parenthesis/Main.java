import java.util.HashMap;
import java.util.Stack;

class Main {
    public static boolean validParenthesis(String s) {
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');
        Stack<Character> stck = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                if (!stck.isEmpty() && stck.pop() == hm.get(s.charAt(i)))
                    continue;
                else
                    return false;
            } else {
                stck.push(s.charAt(i));
            }

        }
        return stck.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(validParenthesis("()[]{}"));

    }
}