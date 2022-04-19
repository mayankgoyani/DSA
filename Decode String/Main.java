import java.util.Stack;

class Main {

    public static String decode(String s) {
        Stack<String> str = new Stack<>();
        Stack<Integer> count = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int x = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    x = 10 * x + s.charAt(i) - '0';
                    i++;
                }
                count.push(x);
            } else if (s.charAt(i) == '[') {
                str.push(sb.toString());
                sb = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                int y = count.pop();
                StringBuilder temp = new StringBuilder(str.pop());
                for (int j = 0; j < y; j++) {
                    temp.append(sb);
                }
                sb = temp;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decode(s));
    }
}