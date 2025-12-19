package com.leetcode.array;

import org.junit.Test;
import static org.junit.Assert.*;

public class Q0026_RemoveDuplicatesTest {

    @Test
    public void testRemoveDuplicates_基本测试用例() {
        Q0026_RemoveDuplicates solution = new Q0026_RemoveDuplicates();
        
        // 测试用例1：包含重复元素的数组
        int[] nums1 = {1, 1, 2, 2, 3, 4, 4, 5};
        int result1 = solution.removeDuplicates(nums1);
        
        // 验证返回的长度
        assertEquals(5, result1);
        
        // 验证数组前5个元素是去重后的结果
        int[] expected1 = {1, 2, 3, 4, 5};
        for (int i = 0; i < result1; i++) {
            assertEquals(expected1[i], nums1[i]);
        }
    }

    @Test
    public void testRemoveDuplicates_边界情况测试() {
        Q0026_RemoveDuplicates solution = new Q0026_RemoveDuplicates();
        
        // 测试用例2：空数组和单元素数组
        int[] nums2 = {};  // 空数组
        int result2 = solution.removeDuplicates(nums2);
        assertEquals(0, result2);
        
        int[] nums3 = {1};  // 单元素数组
        int result3 = solution.removeDuplicates(nums3);
        assertEquals(1, result3);
        assertEquals(1, nums3[0]);
        
        // 测试用例3：所有元素都相同
        int[] nums4 = {2, 2, 2, 2, 2};
        int result4 = solution.removeDuplicates(nums4);
        assertEquals(1, result4);
        assertEquals(2, nums4[0]);
    }
}
