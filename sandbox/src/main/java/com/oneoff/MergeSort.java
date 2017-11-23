package com.oneoff;


//Divide and conquer algorithm
//Essentially recurse to the point that you have a single value array
//The single value array is sorted by definition.
//Pop the stack until you have two single value arrays
public class MergeSort {

    static int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    //Divide and conquer
    static void sort(int[] array, int leftIndex, int rightIndex) {
        //When get to one then list of one is sorted
        if (rightIndex > leftIndex) {
            //split in the middle, but be sure to keep middle index relative to
            //the left index
            int leftOfMiddleIndex = leftIndex + ((rightIndex - leftIndex) / 2);
            sort(array, leftIndex, leftOfMiddleIndex);
            sort(array, leftOfMiddleIndex + 1, rightIndex);
            merge(array, leftIndex, leftOfMiddleIndex, rightIndex);
        }
    }

    //middle index used for computing the length of the arrays
    static void merge(int[] array, int leftIndex, int leftOfMiddleIndex, int rightIndex) {
        //Create scratch arrays and use them to merge them into the existing array in the correct sorted order.
        //Don't forget that the length of the array is the difference between the beginning and the end index
        int[] left = new int[leftOfMiddleIndex - leftIndex + 1]; //when middleIndex and leftIndex = 0 (array size 2 need array size 1
        int[] right = new int[rightIndex - leftOfMiddleIndex];

        //use iterating integer as offset from the beginning index
        for(int i = 0; i < left.length; i++) {
            left[i] = array[leftIndex + i];
        }

        int rightOfMiddleIndex = leftOfMiddleIndex + 1;
        for(int i = 0; i < right.length; i++) {
           right[i] = array[rightOfMiddleIndex + i];
        }

        int currIndex = 0;

        //You must keep track of the index of next value in the left and right arrays
        //that will be compared.
        int leftPtr = 0;
        int rightPtr = 0;

        //Stop if either left or right index exceeds the length of the
        //associated sorted array.
        for (int i = 0; (leftPtr != left.length && rightPtr != right.length) ; i++) {
            currIndex = leftIndex + i;

            //update the original array from the two sorted
            //arrays
            if (left[leftPtr] > right[rightPtr]) {
                array[currIndex] = right[rightPtr];
                rightPtr += 1;
            }
            else {
                array[currIndex] = left[leftPtr];
                leftPtr += 1;
            }
        }

        //Be sure to get the remaining values in each of the sorted arrays.
        for (;leftPtr < left.length; leftPtr++) {
            currIndex++;
            array[currIndex] = left[leftPtr];
        }

        for(;rightPtr < right.length; rightPtr++) {
            currIndex++;
            array[currIndex] = right[rightPtr];
        }
    }
}
