package com.oneoff;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testOne() {
        int[] integers = {3};
        int[] result = MergeSort.sort(integers);

        Assert.assertArrayEquals(new int []{3}, result );
    }

    @Test
    public void testTwo() {
        int[] integers = {27, 3};
        int[] result = MergeSort.sort(integers);

        Assert.assertArrayEquals(new int []{3, 27}, result );
    }


    @Test
    public void testThree() {
        int[] integers = {27, 3, 1};
        int[] result = MergeSort.sort(integers);

        Assert.assertArrayEquals(new int []{1, 3, 27}, result );
    }


    @Test
    public void testFour() {
        int[] integers = {27, 3, 13, 1};
        int[] result = MergeSort.sort(integers);

        Assert.assertArrayEquals(new int []{1, 3, 13, 27}, result );
    }

    @Test
    public void testSorted() {
        int[] integers = {1, 3, 13, 27};
        int[] result = MergeSort.sort(integers);

        Assert.assertArrayEquals(new int []{1, 3, 13, 27}, result );
    }
}
