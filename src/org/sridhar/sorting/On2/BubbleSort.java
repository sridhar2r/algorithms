package org.sridhar.sorting.On2;

import org.sridhar.sorting.utils.SortUtil;

/**
 * Created by sridharrajagopal on 3/22/20.
 * Time complexity - O(n ^ 2)
 * Space complexity - O(1)
 * In place algorithm
 * Stable algorithm - e.g., {2(a), 2(b), 1(c)}
 * Swapping happens when element is lower than adjacent element. So if we have two equal elements,  the second element
 * only has a possibility of getting swapped to the position after 1st element
 * e.g. {9(d), 2(a), 2(b), 10(c)}
 *   -- {2(a), 9(d), 2(b), 10(c)}
 *   -- {2(a), 2(b), 9(d), 10(c)}
 *
 * Compares each element with adjacent element and if it is out of order it is swapped.
 * This is repeated for n times till entire array is sorted
 * Optimizations : 1, Having a isSorted flag to check if iteration went without sorting and stop if it does
 * 2, Having unsorted array length variable. During each iteration last n-1 elements becomes sorted and largest
 * elements move to right side. (largest element bubble up to right after each iteration
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int[] arr = {9,6,5,3,2};
        //int[] arr = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
        int[] arr = {9,6,7,6,2};
        //int[] arr = {9,2,2,10};
        performBubbleSortOptimized(arr);
        SortUtil.printArray(arr);
    }

    private static void performBubbleSortOptimized(int[] arr) {
        boolean isSorted = false;
        int unSortedLen = arr.length;
        while (!isSorted) {
            isSorted = true;
            for(int count = 1; count < unSortedLen; count++) {
                if(arr[count] < arr[count - 1]) {
                    SortUtil.swap(arr, count, count - 1);
                    isSorted = false;
                }
            }
            unSortedLen --;
        }
    }

    private static void performBubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                if(arr[j] < arr[j - 1]) {
                    SortUtil.swap(arr, j , j - 1);
                }
            }
        }
    }
}
