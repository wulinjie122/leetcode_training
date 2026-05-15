package com.leetcode.array;

import java.util.Map;
import java.util.HashMap;

/**
 * 两数之和
 * <p>
 * 题目描述：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 解题思路：使用哈希表（HashMap）来存储已经遍历过的元素及其下标。对于每一个当前元素 nums[i]，
 * 计算需要找到的目标值 complement = target - nums[i]，如果 complement 在哈希表中存在，
 * 则返回当前元素下标 i 和 complement 对应的下标。否则，将当前元素及其下标存入哈希表中。
 * <p>
 * 时间复杂度：O(n)，其中 n 是数组的长度。
 * 空间复杂度：O(n)，需要使用哈希表存储最多 n 个元素。
 */
public class Q0001_TwoSum {
    
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];   // 遍历当前元素，并在map中寻找是否有匹配的key
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);    // 如果没找到匹配对，就把访问过的元素和下标加入到map中
        }
        return res;
    }

    // 测试方法
    public static void main(String[] args) {
        Q0001_TwoSum solution = new Q0001_TwoSum();
        
        // 示例
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.print("示例输出: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println("]"); // 应输出 [0, 1]
    }
}