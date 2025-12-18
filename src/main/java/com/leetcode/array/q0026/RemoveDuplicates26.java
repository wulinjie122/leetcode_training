package com.leetcode.array.q0026;

/**
 * LeetCode 26. 删除有序数组中的重复项
 * 
 * 题目描述：
 * 给你一个有序数组 nums，请你原地删除重复出现的元素，使每个元素只出现一次，
 * 返回删除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 
 * 示例：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 
 * 解题思路：
 * 使用双指针法，快指针遍历数组，慢指针记录不重复元素的位置
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class RemoveDuplicates26 {

    public int removeDuplicates(int[] nums) {
        // 处理边界情况：如果数组为空，则直接返回0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 初始化慢指针，从第一个元素开始（它已经是结果的一部分）
        int slow = 0;

        // 快指针从第二个元素开始遍历整个数组
        for (int fast = 1; fast < nums.length; fast++) {
            // 如果快指针指向的元素不等于慢指针指向的元素
            if (nums[fast] != nums[slow]) {
                // 慢指针先向后移动一位，为新元素腾位置
                slow++;
                // 将快指针找到的新元素复制到慢指针的新位置
                nums[slow] = nums[fast];
            }
            // 如果相等，快指针继续前进，慢指针不动（跳过重复元素）
        }

        // 新数组的长度是慢指针索引 + 1
        return slow + 1;
    }
}
