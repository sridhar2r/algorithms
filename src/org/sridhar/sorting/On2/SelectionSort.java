package org.sridhar.sorting.On2;

import org.sridhar.sorting.utils.SortUtil;

/**
 * Created by sridharrajagopal on 3/23/20.
 * Time complexity : O(n ^ 2)
 * Space complexity : O(1)
 * In place algorithm
 * unstable algorithm - Consider {2(a), 2(b), 1(c)}
 * In first iteration, smallest element is 1(c). 1(c) is swapped with 2(a) and it will remain after 2(b) even after
 * algorithm completes. Final order {1(c), 2(b), 2(a)}
 *
 *
 * Look through entire array for the smallest element, swap it first element
 * Move to second element and look through entire array for the smallest element, swap it with second element
 * Repeat till end of array
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9, 6, 5, 3, 2};
        performSelectionSort(arr);
    }

    private static void performSelectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minElt = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElt]) {
                    minElt = j;
                }
            }
            SortUtil.swap(arr, minElt, i);
        }
    }
}
