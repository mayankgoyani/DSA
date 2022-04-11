import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

// Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
// Note: can you take care of the duplicates without using any additional Data Structure?

class Main {
    static ArrayList<Integer> commonElements(int[] A, int[] B, int[] C) {
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        HashSet<Integer> hs3 = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            hs1.add(A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            if (hs1.contains(B[i]))
                hs2.add(B[i]);
        }
        for (int i = 0; i < C.length; i++) {
            if (hs2.contains(C[i]))
                hs3.add(C[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(hs3);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        int[] A = new int[] { 1, 5, 10, 20, 40, 80 };
        int[] B = new int[] { 6, 7, 20, 80, 100 };
        int[] C = new int[] { 3, 4, 15, 20, 30, 70, 80, 120 };
        commonElements(A, B, C).forEach(value -> System.out.print(value + " "));
    }
}