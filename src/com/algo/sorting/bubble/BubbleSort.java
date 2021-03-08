package com.algo.sorting.bubble;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] arg) {
        int[] a = {2,1,9,5,6,3};
        System.out.println(Arrays.toString(sort(a)));
    }

    public static int[] sort(int[] a) {
        int temp = 0;
        boolean swapped = true;
        while (swapped){
            swapped = false;
            for(int j=0; j<a.length-1; j++) {
                if (a[j] > a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swapped = true;
                }
            }
        }
        return a;
    }
}
