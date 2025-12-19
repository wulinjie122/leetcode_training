package com.leetcode.array;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Q0977_SquaresOfSortedArray 的测试类
 */
public class Q0977_SquaresOfSortedArrayTest {

    @Test
    public void testSortedSquares_BasicTestCase() {
        Q0977_SquaresOfSortedArray solution = new Q0977_SquaresOfSortedArray();
        
        // 测试用例1：包含负数的数组
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] result1 = solution.sortedSquares(nums1);
        int[] expected1 = {0, 1, 9, 16, 100};
        assertArrayEquals(expected1, result1);
    }

    @Test
    public void testSortedSquares_AllNegativeNumbers() {
        Q0977_SquaresOfSortedArray solution = new Q0977_SquaresOfSortedArray();
        
        // 测试用例2：全负数数组
        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] result2 = solution.sortedSquares(nums2);
        int[] expected2 = {4, 9, 9, 49, 121};
        assertArrayEquals(expected2, result2);
    }

    @Test
    public void testSortedSquares_AllPositiveNumbers() {
        Q0977_SquaresOfSortedArray solution = new Q0977_SquaresOfSortedArray();
        
        // 测试用例3：全正数数组
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] result3 = solution.sortedSquares(nums3);
        int[] expected3 = {1, 4, 9, 16, 25};
        assertArrayEquals(expected3, result3);
    }

    @Test
    public void testSortedSquares_SingleElement() {
        Q0977_SquaresOfSortedArray solution = new Q0977_SquaresOfSortedArray();
        
        // 测试用例4：单元素数组
        int[] nums4 = {-5};
        int[] result4 = solution.sortedSquares(nums4);
        int[] expected4 = {25};
        assertArrayEquals(expected4, result4);
    }

    @Test
    public void testSortedSquares_ArrayWithZero() {
        Q0977_SquaresOfSortedArray solution = new Q0977_SquaresOfSortedArray();
        
        // 测试用例5：包含零的数组
        int[] nums5 = {-2, 0, 2};
        int[] result5 = solution.sortedSquares(nums5);
        int[] expected5 = {0, 4, 4};
        assertArrayEquals(expected5, result5);
    }
}
