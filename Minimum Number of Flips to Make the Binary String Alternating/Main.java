class Main {

    static int minFlips(String s) {
            int even0 = 0;
            int odd0 = 0;
            int even1 = 0;
            int odd1 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    if (s.charAt(i) == '1') {
                        even1++;
                    } else {
                        even0++;
                    }
                } else {
                    if (s.charAt(i) == '1') {
                        odd1++;
                    } else {
                        odd0++;
                    }
                }
            }
            
            return Math.min(odd0 + even1 , odd1 +even0);
    }

    public static void main(String[] args) {
        System.out.println(minFlips("0001010111"));
    }
}