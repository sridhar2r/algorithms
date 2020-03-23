package org.sridhar.searching;

import java.util.Arrays;

/**
 * Created by sridharrajagopal on 3/24/20.
 * Works for sorted array
 * Time complexity : O(logn)
 * Best case : O(1)
 *
 * Base condition : Check if left > right, return -1
 * Find middle = (left+right)/2
 * if search nbr is in middle return middle
 * if search nbr is less than middle
 *      perform binary search in left of middle, else perform binary search in right of middle
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {9, 6, 5, 3, 2};
        //int[] arr =  {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(performBinarySearch(arr, 9));
    }

    private static int performBinarySearch(int[] arr, int searchNbr) {
        int left = 0;
        int right = arr.length - 1;

        return performBinarySearch(arr, left, right, searchNbr);
    }

    private static int performBinarySearch(int[] arr, int left, int right, int searchNbr) {
        if(left > right) {
            return  -1;
        } else  {
            int middle = (left + right) / 2;
            if (arr[middle] == searchNbr) {
                return middle;
            } else {
                if (arr[middle] < searchNbr) {
                    return performBinarySearch(arr, middle + 1, right, searchNbr);
                } else {
                    return performBinarySearch(arr, left, middle - 1, searchNbr);
                }
            }
        }
    }
}
