class Main {
    public static int countSubstring(String s) {
        int prevCount = 0;
        int currCount = 1;  
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                result += Math.min(prevCount, currCount);
                prevCount = currCount;
                currCount = 1;
            } else {
                currCount++;
            }

        }

        result += Math.min(currCount, prevCount);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSubstring("0100110101"));
    }
}