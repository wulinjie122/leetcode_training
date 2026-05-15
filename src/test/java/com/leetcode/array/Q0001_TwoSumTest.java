package com.leetcode.array;

import org.junit.Test;
import static org.junit.Assert.*;

public class Q0001_TwoSumTest {
    
    @Test
    public void testTwoSum_基本测试用例() {
        Q0001_TwoSum solution = new Q0001_TwoSum();
        
        // 测试用例1：示例中的基本情况
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        
        // 验证结果数组长度为2
        assertEquals(2, result1.length);
        
        // 验证结果是正确的下标组合
        assertTrue((result1[0] == 0 && result1[1] == 1) || (result1[0] == 1 && result1[1] == 0));
    }
    
    @Test
    public void testTwoSum_多组解的情况() {
        Q0001_TwoSum solution = new Q0001_TwoSum();
        
        // 测试用例2：存在多组解但只返回一组
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        
        // 验证结果数组长度为2
        assertEquals(2, result2.length);
        
        // 验证结果是正确的下标组合
        assertTrue((result2[0] == 1 && result2[1] == 2) || (result2[0] == 2 && result2[1] == 1));
    }
    
    @Test
    public void testTwoSum_相同元素的情况() {
        Q0001_TwoSum solution = new Q0001_TwoSum();
        
        // 测试用例3：包含相同元素的数组
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        
        // 验证结果数组长度为2
        assertEquals(2, result3.length);
        
        // 验证结果是正确的下标组合
        assertTrue((result3[0] == 0 && result3[1] == 1) || (result3[0] == 1 && result3[1] == 0));
    }
    
    @Test
    public void testTwoSum_负数情况() {
        Q0001_TwoSum solution = new Q0001_TwoSum();
        
        // 测试用例4：包含负数的数组
        int[] nums4 = {-1, -2, -3, -4, -5};
        int target4 = -8;
        int[] result4 = solution.twoSum(nums4, target4);
        
        // 验证结果数组长度为2
        assertEquals(2, result4.length);
        
        // 验证结果是正确的下标组合
        assertTrue((result4[0] == 2 && result4[1] == 4) || (result4[0] == 4 && result4[1] == 2));
    }
}
