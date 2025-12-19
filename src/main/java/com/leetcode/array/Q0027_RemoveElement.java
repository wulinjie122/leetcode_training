package com.leetcode.array;

/**
 * LeetCode 27. 移除元素
 * 
 * 题目描述：
 * 给你一个数组 nums 和一个值 val，你需要原地删除所有数值等于 val 的元素，
 * 并返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。也就是说，查询结果为 [1,2] 但长度是 2 的数组，
 * 在函数里修改输入数组对于调用者是可见的。
 * 
 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 * 
 * 解题思路：
 * 方法1：双指针法（推荐）- 快慢指针
 * 方法2：双指针法 - 左右指针
 * 方法3：覆盖法 - 遇到val就跳过，否则覆盖到当前位置
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Q0027_RemoveElement {

    /**
     * 方法1：快慢指针法（推荐）
     * 慢指针指向下一个要填充的位置，快指针遍历数组
     * 当快指针指向的元素不等于val时，将其复制到慢指针位置
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int slow = 0; // 慢指针，指向下一个要填充的位置
        
        // 快指针遍历整个数组
        for (int fast = 0; fast < nums.length; fast++) {
            // 如果当前元素不等于要删除的值
            if (nums[fast] != val) {
                // 将当前元素复制到慢指针位置
                nums[slow] = nums[fast];
                // 慢指针向前移动
                slow++;
            }
            // 如果等于val，快指针继续前进，慢指针不动（跳过该元素）
        }
        
        return slow; // 返回新数组的长度
    }

    /**
     * 方法2：左右指针法
     * 左指针从左边开始，右指针从右边开始
     * 当左指针遇到val时，用右指针的值覆盖，右指针左移
     * 当左指针不是val时，左指针右移
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int removeElementTwoPointers(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            if (nums[left] == val) {
                // 左指针遇到val，用右指针的值覆盖
                nums[left] = nums[right];
                right--; // 右指针左移
            } else {
                // 左指针不是val，左指针右移
                left++;
            }
        }
        
        return left; // 返回新数组的长度
    }

    /**
     * 方法3：覆盖法（优化版）
     * 使用一个指针遍历数组，遇到非val元素就覆盖到当前位置
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int removeElementOptimized(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int index = 0; // 指向下一个要填充的位置
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        
        return index;
    }

    /**
     * 方法4：统计法
     * 先统计val的个数，然后移动非val元素到正确位置
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int removeElementCount(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int count = 0; // 统计val的个数
        
        // 第一遍：统计val的个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            }
        }
        
        // 第二遍：移动非val元素
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        
        return nums.length - count; // 返回新数组的长度
    }
}
