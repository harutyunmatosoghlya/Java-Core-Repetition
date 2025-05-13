package sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = {4, 7, 1, 3, 9, 0, 2};
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        Arrays.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}