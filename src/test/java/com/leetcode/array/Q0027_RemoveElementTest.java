package com.leetcode.array;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Q0027_RemoveElement 的测试类
 */
public class Q0027_RemoveElementTest {

    @Test
    public void testRemoveElement_基本测试用例() {
        Q0027_RemoveElement solution = new Q0027_RemoveElement();
        
        // 测试用例1：LeetCode示例1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int result1 = solution.removeElement(nums1, val1);
        
        assertEquals(2, result1);
        // 验证前2个元素不包含val
        for (int i = 0; i < result1; i++) {
            assertNotEquals(val1, nums1[i]);
        }
    }

    @Test
    public void testRemoveElement_LeetCode示例2() {
        Q0027_RemoveElement solution = new Q0027_RemoveElement();
        
        // 测试用例2：LeetCode示例2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int result2 = solution.removeElement(nums2, val2);
        
        assertEquals(5, result2);
        // 验证前5个元素不包含val
        for (int i = 0; i < result2; i++) {
            assertNotEquals(val2, nums2[i]);
        }
    }

    @Test
    public void testRemoveElement_边界情况() {
        Q0027_RemoveElement solution = new Q0027_RemoveElement();
        
        // 测试用例3：空数组
        int[] nums3 = {};
        int result3 = solution.removeElement(nums3, 1);
        assertEquals(0, result3);
        
        // 测试用例4：null数组
        int[] nums4 = null;
        int result4 = solution.removeElement(nums4, 1);
        assertEquals(0, result4);
        
        // 测试用例5：单元素数组，不匹配
        int[] nums5 = {1};
        int result5 = solution.removeElement(nums5, 2);
        assertEquals(1, result5);
        assertEquals(1, nums5[0]);
        
        // 测试用例6：单元素数组，匹配
        int[] nums6 = {1};
        int result6 = solution.removeElement(nums6, 1);
        assertEquals(0, result6);
    }

    @Test
    public void testRemoveElement_所有元素都等于val() {
        Q0027_RemoveElement solution = new Q0027_RemoveElement();
        
        // 测试用例7：所有元素都等于val
        int[] nums7 = {2, 2, 2, 2};
        int val7 = 2;
        int result7 = solution.removeElement(nums7, val7);
        
        assertEquals(0, result7);
    }

    @Test
    public void testRemoveElement_没有元素等于val() {
        Q0027_RemoveElement solution = new Q0027_RemoveElement();
        
        // 测试用例8：没有元素等于val
        int[] nums8 = {1, 2, 3, 4, 5};
        int val8 = 6;
        int result8 = solution.removeElement(nums8, val8);
        
        assertEquals(5, result8);
        // 验证所有元素都保持不变
        int[] expected8 = {1, 2, 3, 4, 5};
        for (int i = 0; i < result8; i++) {
            assertEquals(expected8[i], nums8[i]);
        }
    }

    @Test
    public void testRemoveElement_val在开头和结尾() {
        Q0027_RemoveElement solution = new Q0027_RemoveElement();
        
        // 测试用例9：val在开头和结尾
        int[] nums9 = {1, 2, 3, 1, 4, 1};
        int val9 = 1;
        int result9 = solution.removeElement(nums9, val9);
        
        assertEquals(3, result9);
        // 验证前3个元素不包含val
        for (int i = 0; i < result9; i++) {
            assertNotEquals(val9, nums9[i]);
        }
    }

    @Test
    public void testRemoveElementTwoPointers_左右指针法() {
        Q0027_RemoveElement solution = new Q0027_RemoveElement();
        
        // 测试左右指针法
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int result = solution.removeElementTwoPointers(nums, val);
        
        assertEquals(2, result);
        for (int i = 0; i < result; i++) {
            assertNotEquals(val, nums[i]);
        }
    }

    @Test
    public void testRemoveElementOptimized_优化版() {
        Q0027_RemoveElement solution = new Q0027_RemoveElement();
        
        // 测试优化版
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int result = solution.removeElementOptimized(nums, val);
        
        assertEquals(5, result);
        for (int i = 0; i < result; i++) {
            assertNotEquals(val, nums[i]);
        }
    }

    @Test
    public void testRemoveElementCount_统计法() {
        Q0027_RemoveElement solution = new Q0027_RemoveElement();
        
        // 测试统计法
        int[] nums = {1, 2, 3, 2, 4, 2, 5};
        int val = 2;
        int result = solution.removeElementCount(nums, val);
        
        assertEquals(4, result);
        for (int i = 0; i < result; i++) {
            assertNotEquals(val, nums[i]);
        }
    }

    @Test
    public void testRemoveElement_性能测试() {
        Q0027_RemoveElement solution = new Q0027_RemoveElement();
        
        // 测试用例10：大数组性能测试
        int[] nums10 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums10[i] = i % 3 == 0 ? 1 : i; // 每3个元素有一个1
        }
        
        int result10 = solution.removeElement(nums10, 1);
        assertEquals(665, result10); // 1000 - 335 = 665 (0,3,6,9...999，共335个1)
        
        // 验证结果中没有1
        for (int i = 0; i < result10; i++) {
            assertNotEquals(1, nums10[i]);
        }
    }
}
