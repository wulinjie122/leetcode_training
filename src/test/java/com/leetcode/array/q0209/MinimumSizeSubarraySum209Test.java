package com.leetcode.array.q0209;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * 测试类：MinimumSizeSubarraySum209的测试用例
 */
public class MinimumSizeSubarraySum209Test {

    private final MinimumSizeSubarraySum209 solution = new MinimumSizeSubarraySum209();

    /**
     * 基本测试用例
     */
    @Test
    public void testMinSubArrayLen_BasicCase() {
        // 示例1：常规情况
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int expected1 = 2; // 子数组[4,3]
        
        int result1 = solution.minSubArrayLen(target1, nums1);
        // int result1Brute = solution.minSubArrayLen_bruteForce(target1, nums1);
        
        assertEquals("双指针解法应该返回正确的最小长度", expected1, result1);
        // assertEquals("暴力解法应该返回正确的最小长度", expected1, result1Brute);
    }

    /**
     * 单元素满足条件
     */
    @Test
    public void testMinSubArrayLen_SingleElement() {
        // 示例2：单个元素满足条件
        int target2 = 4;
        int[] nums2 = {1, 4, 4};
        int expected2 = 1; // 子数组[4]
        
        int result2 = solution.minSubArrayLen(target2, nums2);
        int result2Brute = solution.minSubArrayLen_bruteForce(target2, nums2);
        
        assertEquals("双指针解法应该返回正确的最小长度", expected2, result2);
        assertEquals("暴力解法应该返回正确的最小长度", expected2, result2Brute);
    }

    /**
     * 无满足条件的子数组
     */
    @Test
    public void testMinSubArrayLen_NoSolution() {
        // 示例3：没有满足条件的子数组
        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int expected3 = 0; // 所有元素和为8，小于11
        
        int result3 = solution.minSubArrayLen(target3, nums3);
        int result3Brute = solution.minSubArrayLen_bruteForce(target3, nums3);
        
        assertEquals("双指针解法应该返回0", expected3, result3);
        assertEquals("暴力解法应该返回0", expected3, result3Brute);
    }

    /**
     * 边界情况：数组只有一个元素
     */
    @Test
    public void testMinSubArrayLen_OneElementArray() {
        // 测试只有一个元素的数组
        int target4 = 5;
        int[] nums4 = {3}; // 单个元素小于target
        int expected4 = 0;
        
        int result4 = solution.minSubArrayLen(target4, nums4);
        int result4Brute = solution.minSubArrayLen_bruteForce(target4, nums4);
        
        assertEquals("双指针解法应该返回0", expected4, result4);
        assertEquals("暴力解法应该返回0", expected4, result4Brute);
        
        // 单个元素等于target
        int target5 = 5;
        int[] nums5 = {5};
        int expected5 = 1;
        
        int result5 = solution.minSubArrayLen(target5, nums5);
        int result5Brute = solution.minSubArrayLen_bruteForce(target5, nums5);
        
        assertEquals("双指针解法应该返回1", expected5, result5);
        assertEquals("暴力解法应该返回1", expected5, result5Brute);
    }

    /**
     * 边界情况：全部元素和刚好等于target
     */
    @Test
    public void testMinSubArrayLen_AllElementsSum() {
        // 整个数组的和刚好等于target
        int target6 = 10;
        int[] nums6 = {2, 3, 5};
        int expected6 = 3;
        
        int result6 = solution.minSubArrayLen(target6, nums6);
        int result6Brute = solution.minSubArrayLen_bruteForce(target6, nums6);
        
        assertEquals("双指针解法应该返回3", expected6, result6);
        assertEquals("暴力解法应该返回3", expected6, result6Brute);
    }

    /**
     * 性能测试：大数组
     */
    @Test
    public void testMinSubArrayLen_LargeArray() {
        // 大数组测试，第一个元素就满足条件
        int target7 = 10000;
        int[] nums7 = new int[1000];
        nums7[0] = 20000; // 第一个元素就满足条件
        for (int i = 1; i < nums7.length; i++) {
            nums7[i] = 1;
        }
        int expected7 = 1;
        
        int result7 = solution.minSubArrayLen(target7, nums7);
        int result7Brute = solution.minSubArrayLen_bruteForce(target7, nums7);
        
        assertEquals("双指针解法应该返回1", expected7, result7);
        assertEquals("暴力解法应该返回1", expected7, result7Brute);
    }
}