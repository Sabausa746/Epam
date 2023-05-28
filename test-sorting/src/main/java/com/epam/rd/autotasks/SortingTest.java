package com.epam.rd.autotasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;



public class SortingTest {

    Sorting sorting = new Sorting();


    @Test
    public void testNullCase() {
        assertThrows(IllegalArgumentException.class, () -> sorting.sort(null));
    }

    @Test
    public void testEmptyCase() {
        int[] expected = {};
        int[] arr = {};
        sorting.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSingleElementArrayCase() {
        int[] expected = {0};
        int[] arr = {0};
        sorting.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortedArraysCase() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] arr = {3, 2, 5, 4, 1};
        sorting.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testOtherCases() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] arr = {3, 2, 5, 4, 1};
        sorting.sort(arr);
        assertArrayEquals(expected, arr);
    }

}