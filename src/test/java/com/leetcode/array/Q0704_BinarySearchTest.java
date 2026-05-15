package com.leetcode.array;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Q0704_BinarySearchTest {
    
    private final Q0704_BinarySearch solution = new Q0704_BinarySearch();
    
    @Test
    public void testSearch_ExistingTarget() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int expected = 4;
        assertEquals(expected, solution.search(nums, target));
    }
    
    @Test
    public void testSearch_NonExistingTarget() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int expected = -1;
        assertEquals(expected, solution.search(nums, target));
    }
    
    @Test
    public void testSearch_SingleElementArray_Found() {
        int[] nums = {5};
        int target = 5;
        int expected = 0;
        assertEquals(expected, solution.search(nums, target));
    }
    
    @Test
    public void testSearch_SingleElementArray_NotFound() {
        int[] nums = {5};
        int target = 3;
        int expected = -1;
        assertEquals(expected, solution.search(nums, target));
    }
    
    @Test
    public void testSearch_EmptyArray() {
        int[] nums = {};
        int target = 5;
        int expected = -1;
        assertEquals(expected, solution.search(nums, target));
    }
}