package org.sridhar.sorting.On2;

import org.sridhar.sorting.utils.SortUtil;

import java.util.Arrays;

/**
 * Created by sridharrajagopal on 3/23/20.
 * Time complexity : O(n^2)
 * i = 1  2  3  3  4 .... n-1
 * j = 1  2  3  4  5 .... n-1
 * Time Complexity = 1 + 2 + 3 + 4 + 5... n-1 = n(n-1)/2 = n ^ 2 = O(n^2)
 * Best Case complexity, already sorted array. Only sorted portion is built from left to right : Omega(n)
 * Space complexity : O(1)
 * Inplace algorithm
 * stable algorithm - e.g., {2(a), 2(b), 1(c)}
 * First iteration  - {2(a), 2(b)| 1(c)} -> 2(b) inserted in sorted array
 * Second iteration - {2(a),  |2(b)} elementToCompare = 1(c)
 *                    { ,2(a)|2(b)} elementToCompare = 1(c)
 *                    {1(c), 2(a), 2(b)}
 *
 * Assume first element of array to be sorted and remaining elements to be unsorted.
 * Take first element from unsorted array and make it as element to be compared
 * compare element to compare with last element in sorted array. If sorted array element is greater than element to compare swap, and reduce the index in sorted array
 * Repeat this till all elements in sorted array are compared and element to be compared reaches right position in sorted array. Increment size of sorted array(i) by 1
 * Start with next element to compare in unsorted array.
 * Repeat this process till all elements move to sorted array.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {23,42,4,16,8,15};
        //int[] arr = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};

        System.out.println("Before Sort " +Arrays.toString(arr));
        performInsertionSort(arr);
        System.out.println("After Sort " +Arrays.toString(arr));
    }

    private static void performInsertionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int elementToCompare = arr[i + 1];
            int index  = i + 1;
            for(int j = i; j >= 0; j--) {
                if(elementToCompare < arr[j]) {
                    SortUtil.swap(arr, j, index--);
                }
            }
        }
    }

    /*
        Below is better than above as we don't loop through sorted portion if we encounter a element in sorted
        portion which is less than the elementToCompare. Other implementation always runs through the entire
        sorted array.
        Consider array  = {23, 42, 4, 16, 8, 15}
        This variation works as follows
        Step 1, i=1, j = 1, arr[0](23) > elementToCompare(42) => false, insert 42 into 1st position in sorted array: 23 | 42 4 16 8 15
        Step 2, i=2, j = 2, arr[1](42) > elementToCompare(4) => true, arr[j] = arr[j-1] : 23   | 42 16 8 15, elementToCompare 4
                i=2, j = 1, arr[0](23) > elementToCompare(4) => true, arr[j] = arr[j-1] :    23| 42 16 8 15, elementToCompare 4
                i=2, j = 0, exit while, insert a[j] = elementToCompare :  4 23 | 42 16 8 15
        Step 3, i=3, j = 3, arr[2](42) > elementToCompare(16) => true, arr[j] = arr[j-1] : 4 23  |42 8 15, elementToCompare 16
                i=3, j = 2, arr[1](23) > elementToCompare(16) => true, arr[j] = arr[j-1] : 4   23|42 8 15, elementToCompare 16
                i=3, j = 1, arr[0](4)  > elementToCompare(16) => false exit while, insert a[j] = elementToCompare :  4 16 23|42 8 15
        Repeat till i reaches 6
     */
    private static void performInsertionSortVariation(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int elementToCompare = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > elementToCompare) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = elementToCompare;
        }
    }
}
