package org.sridhar.sorting.On2;

import org.sridhar.sorting.testStable.StableCls;
import org.sridhar.sorting.utils.SortUtil;

import java.util.Arrays;

/**
 * Created by sridharrajagopal on 3/23/20.
 */
public class StableAlgorithmEvaluation {
    public static void main(String[] args) {
        StableCls[] stableArr = SortUtil.getStableArr();
        System.out.println("Before Sort " + Arrays.toString(stableArr));
        //performInsertionSortStable(stableArr);
        performSelectionSortSortable(stableArr);
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

    private static void performSelectionSortSortable(StableCls[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minElt = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getNbr() < arr[minElt].getNbr()) {
                    minElt = j;
                }
            }
            SortUtil.swap(arr, minElt, i);
        }
    }
}
