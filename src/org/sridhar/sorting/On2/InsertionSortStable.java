package org.sridhar.sorting.On2;

import org.sridhar.sorting.testStable.StableCls;
import org.sridhar.sorting.utils.SortUtil;

import java.util.Arrays;

/**
 * Created by sridharrajagopal on 3/23/20.
 * Time complexity : O(n^2)
 * i = 0  1  2  3  4 .... n-1
 * j = 1  2  3  4  5 .... n
 * Time Complexity = 1 + 2 + 3 + 4 + 5... n = n(n+1)/2 = n ^ 2 = O(n^2)
 * Space complexity : O(1)
 * Inplace, stable algorithm
 */
public class InsertionSortStable {
    public static void main(String[] args) {
        StableCls[] stableArr = SortUtil.getStableArr();
        System.out.println("Before Sort " + Arrays.toString(stableArr));
        performInsertionSortStable(stableArr);
        System.out.println("After Sort " +Arrays.toString(stableArr));
    }

    private static void performInsertionSortStable(StableCls[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            StableCls elementToCompare = arr[i + 1];
            int index  = i + 1;
            for(int j = i; j >= 0; j--) {
                if(elementToCompare.getNbr() < arr[j].getNbr()) {
                    SortUtil.swap(arr, j, index--);
                }
            }
        }
    }
}
