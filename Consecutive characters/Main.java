class Main {

    public static int maxConsecutiveCharacters(String s) {
        int count = 0;
        int max = 0;
        char previous = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == previous) {
                count++;
            } else {

                count = 1;
                previous = c;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(maxConsecutiveCharacters("leeeeeeeeeeeeeeeeeeeeeeeeetcode"));

    }
}