package com.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 解法：哈希集合法
 */
public class Q0349_IntersectionOfTwoArrays {

    /**
     * 哈希集合法：通过集合去重和查找交集
     * 时间复杂度：O(m + n)，其中 m 和 n 是两个数组的长度
     * 空间复杂度：O(min(m, n))，存储较小数组的元素
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // 用哈希集合存储第一个数组的元素（去重）
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // 用另一个集合存储交集元素（避免重复）
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // 将结果集合转换为数组
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }
        return result;
    }

    // 测试方法
    public static void main(String[] args) {
        Q0349_IntersectionOfTwoArrays solution = new Q0349_IntersectionOfTwoArrays();
        
        // 示例 1
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result1 = solution.intersection(nums1, nums2);
        System.out.print("示例 1 输出: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) System.out.print(", ");
        }
        System.out.println("]"); // 应输出 [2]

        // 示例 2
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] result2 = solution.intersection(nums3, nums4);
        System.out.print("示例 2 输出: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(", ");
        }
        System.out.println("]"); // 应输出 [9, 4] 或 [4, 9]
    }
}
