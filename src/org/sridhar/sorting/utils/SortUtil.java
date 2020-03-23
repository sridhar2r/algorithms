package org.sridhar.sorting.utils;

import org.sridhar.sorting.testStable.StableCls;

import java.util.Arrays;

/**
 * Created by sridharrajagopal on 3/22/20.
 */
public class SortUtil {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static StableCls[] getStableArr() {
        //int[] nbrArr = {23,42,4,16,4,15};
        //int[] nbrArr = {5,2,3,8,4,5,6};
        int[] nbrArr = {2,2,1};
        StableCls[] arr = new StableCls[nbrArr.length];
        StableCls stableCls = null;
        for(int count = 0; count < nbrArr.length; count++) {
            stableCls = new StableCls(nbrArr[count], (char) ('A' + count));
            arr[count] = stableCls;
        }
        return arr;
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
