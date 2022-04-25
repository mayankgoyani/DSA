import java.util.Stack;

class Main {
    static int makeValid(String s) {
        Stack<Character> stk = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stk.empty() && stk.peek() == '(') {
                    stk.pop();
                    count--;
                    continue;
                } else {
                    count++;
                }
            } else {
                stk.push(s.charAt(i));
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}