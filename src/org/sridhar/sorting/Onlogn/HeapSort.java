package org.sridhar.sorting.Onlogn;

import org.sridhar.sorting.utils.SortUtil;

/**
 * Created by sridharrajagopal on 3/23/20.
 * Time Complexity : O(nlogn)
 * To build a maxheap : executes n/2 times and heapify takes logn time since each iteration takes 2*root + 1 or 2*root + 2
 * Heap sort : executes n times, and heapify happens in logn time. So time complexity is O(nlogn)
 * Space Complexity : O(1)
 * Below link says recursion can be replaced by iteration to avoid O(logn) space. https://www.toptal.com/developers/sorting-algorithms/heap-sort
 * In place algorithm
 * Unstable algorithm - In heapsort, the maximum element is moved to the end of the array. When you create the heap the order of the elements is lost
 *
 * arr = {10,50,80,60,70,100,200}
 *                10
 *            50        80
 *         60   70  100    200
 * BuildMaxHeap
 *   start with root = 2 and heapify subtree   80 100 200
 *   After heapify at this step we get
 *                 10
 *            50        200
 *         60   70   100     80
 *   next root = 1 and heapify 50 60 70
 *   After heapify at this step we get
 *                 10
 *            70        200
 *         60   50   100     80
 *   next root = 0 and heapify 10 70 200
 *   After heapify at this step we get
 *                 200
 *           70            10
 *        60   50       100   80
 *   heapify 10 100 80
 *                  200
 *           70            100
 *        60   50       10     80
 *
 * HeapSort
 *      Swap 200 and 80 and do heapify
 *                 100
 *            70         80
 *        60     50   10    200
 *      Now 200 is in sorted position. Repeat until we get completely sorted array {10 20 50 70 80 100 200}
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 50, 80, 20, 70, 100, 200};
        buildMaxHeap(arr);
        performHeapSort(arr);
        SortUtil.printArray(arr);
    }

    private static void performHeapSort(int[] arr) {
        for (int count = arr.length; count > 0; count--) {
            SortUtil.swap(arr, 0, count - 1);
            heapify(arr, 0, count - 1);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        for (int root = arr.length / 2 - 1; root >= 0; root--) {
            heapify(arr, root, arr.length);
        }
    }

    private static void heapify(int[] arr, int root, int length) {
        int maxElt = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < length && arr[left] > arr[maxElt]) {
            maxElt = left;
        }

        if (right < length && arr[right] > arr[maxElt]) {
            maxElt = right;
        }
        if (root != maxElt) {
            SortUtil.swap(arr, root, maxElt);
            heapify(arr, maxElt, length);
        }
    }
}
