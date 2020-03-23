package org.sridhar.sorting.Onlogn;

import org.sridhar.sorting.utils.SortUtil;

import java.util.Random;

/**
 * Created by sridharrajagopal on 3/23/20.
 * Time complexity
 * Best, average case - O(nlogn)
 * Worst case - O(n ^ 2)
 * Space complexity - O(logn)
 * Inplace unstable algorithm
 *
 * Partition
 *    Choose a random element as pivot
 *    swap left most element with pivot
 *    move from pivot + 1 to last element
 *    if element is less than pivot
 *          swap pivot+1 with element
 *          swap pivot, pivot+1
 *          increment pivot
 *   return pivot
 * Once partition completes, all elements to left of pivot will be less than pivot and everything to right
 * will be greater than pivot
 *
 * Sorting
 *    Call partition, and get pivot
 *    Call Quick sort for left (arr, left, pivot -1) ( Sorting elements to left of pivot)
 *    Call Quick sort for right(arr, pivot+1, right) ( Sorting elements to right of pivot)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9,6,5,3,2};
        //int[] arr = {10, 50, 80, 20, 70, 100, 200};
       // int[] arr = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
        //int[] arr = {9,6,5,0,8,2,4,7};
        performQuickSort(arr, 0, arr.length - 1);
        SortUtil.printArray(arr);
    }

    private static void performQuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            performQuickSort(arr, left, partition - 1);
            performQuickSort(arr, partition + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        Random random = new Random();
        int pivot = left + random.nextInt(right - left + 1);
        SortUtil.swap(arr, left, pivot);
        pivot = left;
        for (int i = pivot + 1; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                SortUtil.swap(arr, i, pivot + 1);
                SortUtil.swap(arr, pivot, pivot + 1);
                pivot++;
            }
        }
        return pivot;
    }
}
