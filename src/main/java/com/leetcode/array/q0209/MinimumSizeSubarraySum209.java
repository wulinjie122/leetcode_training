package com.leetcode.array.q0209;

/**
 * LeetCode 209. 长度最小的子数组
 * 
 * 题目描述：
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 
 * 解题思路：
 * 1. 暴力解法：双重循环，计算所有可能的子数组和，记录最小长度 - 时间复杂度O(n²)
 * 2. 滑动窗口（双指针）：使用两个指针维护一个窗口，当窗口和大于等于target时，移动左指针 - 时间复杂度O(n)
 */
public class MinimumSizeSubarraySum209 {

    /**
     * 方法1：暴力解法
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     */
    public int minSubArrayLen_bruteForce(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        
        int minLength = Integer.MAX_VALUE;
        
        // 遍历所有可能的起始位置
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // 从起始位置开始累加
            for (int j = i; j < n; j++) {
                sum += nums[j];
                // 一旦找到满足条件的子数组，记录长度并跳出内层循环
                if (sum >= target) {
                    minLength = Math.min(minLength, j - i + 1);
                    break; // 因为后续的子数组长度会更长，所以可以提前结束
                }
            }
        }
        
        // 如果没有找到符合条件的子数组，返回0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /**
     * 方法2：滑动窗口（双指针）解法（推荐）
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        
        int minLength = Integer.MAX_VALUE;
        int left = 0; // 窗口左边界
        int sum = 0;  // 窗口内元素的和
        
        // right作为窗口右边界，不断向右扩展窗口
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            
            // 当窗口和大于等于target时，尝试移动左边界以缩小窗口
            while (sum >= target) {
                // 更新最小长度
                minLength = Math.min(minLength, right - left + 1);
                // 移动左边界，并从sum中减去对应的元素值
                sum -= nums[left++];
            }
        }
        
        // 如果没有找到符合条件的子数组，返回0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}