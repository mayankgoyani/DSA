import java.util.Arrays;

class Main {
    static boolean isIsomorphic(String s, String t) {
        int[] sToT = new int[256];
        Arrays.fill(sToT, -1);

        int[] tToS = new int[256];
        Arrays.fill(tToS, -1);

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (sToT[c1] == -1 && tToS[c2] == -1) {
                sToT[c1] = c2;
                tToS[c2] = c1;
            }

            else if (!(sToT[c1] == c2 && tToS[c2] == c1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }
}