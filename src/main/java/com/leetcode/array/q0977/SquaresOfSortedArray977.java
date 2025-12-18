package com.leetcode.array.q0977;

import java.util.Arrays;

/**
 * LeetCode 977. 有序数组的平方
 * 
 * 题目描述：
 * 给你一个按非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，
 * 要求也按非递减顺序排序。
 * 
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]，排序后变为 [0,1,9,16,100]
 * 
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 
 * 解题思路：
 * 方法1：直接平方后排序 - 时间复杂度O(nlogn)
 * 方法2：双指针法 - 时间复杂度O(n)，利用原数组有序的特性
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1) - 不考虑输出数组
 */
public class SquaresOfSortedArray977 {

    /**
     * 方法1：直接平方后排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    public int[] sortedSquares_01(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 方法2：双指针法（推荐）
     * 利用原数组有序的特性，从两端向中间遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(1) - 不考虑输出数组
     */
    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的，需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
}
