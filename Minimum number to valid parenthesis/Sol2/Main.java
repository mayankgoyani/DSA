class Main {
    static int makeValid(String s) {
        int bal = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            bal += s.charAt(i) == '(' ? 1 : -1;
            if (bal == -1) {
                ans++;
                bal++;
            }
        }
        return ans + bal;
    }

    public static void main(String[] args) {
        System.out.println(makeValid("((()"));
    }
}