package org.sridhar.sorting.Onlogn;

import org.sridhar.sorting.utils.SortUtil;

/**
 * Created by sridharrajagopal on 3/23/20.
 * Time complexity : O(nlogn)
 * Space complexity : O(n)
 * Out of place,
 * stable - have to use <= in mergeHalves method
 *
 * split the array recursively and merge each list
 * merging:
 * Create two lists one of size (middle - left +1) and other of size (right - middle)
 * Insert elements upto middle in first list starting from left
 * Insert elements from middle + 1 to second list till the end
 * compare first element in first list with first element in second list
 *          list1[i] <= list2[j] ->  insert into left, else insert into right
 *  move to next element based on which list gets inserted
 *  Copy remaining elements to end
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 6, 5, 3, 2};
       // int[] arr = {2,2,1};
        mergeSort(arr, 0, arr.length-1);
        SortUtil.printArray(arr);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            mergeHalves(arr, left, middle, right);
        }
    }

    private static void mergeHalves(int[] arr, int left, int middle, int right) {
        int listLength1 = middle - left + 1;
        int listLength2 = right - middle;
        int[] list1 = new int[listLength1];
        int[] list2 = new int[listLength2];
        for (int count = 0; count < listLength1; count++) {
            list1[count] = arr[count + left];
        }
        for (int count = 0; count < listLength2; count++) {
            list2[count] = arr[count + middle + 1];
        }
        int i = 0;
        int j = 0;
        int index = left;
        while (i < listLength1 && j < listLength2) {
            if (list1[i] <= list2[j]) {
                arr[index++] = list1[i++];
            } else {
                arr[index++] = list2[j++];
            }
        }
        while (i < listLength1) {
            arr[index++] = list1[i++];
        }
        while (j < listLength2) {
            arr[index++] = list2[j++];
        }

    }


}
