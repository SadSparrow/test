package org.sparrow;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] arr) {
        boolean isSorted = false;
        int buf;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) { //сортировка в обратном порядке arr[i] > arr[i + 1]
                    isSorted = false;

                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {5, 6, 8, 0, 1};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
