package com.leetcode.array;

/**
 * 242. 有效的字母异位词
 * 哈希表解法：字符计数
 */
public class Q0242_ValidAnagram {

    /**
     * 哈希表解法：通过字符计数判断两个字符串是否为字母异位词
     * 时间复杂度：O(n)，其中 n 是字符串长度，需要遍历两个字符串各一次
     * 空间复杂度：O(1)，因为字符集大小固定（26个小写字母）
     */
    public boolean isAnagram(String s, String t) {
        // 长度不同直接返回 false
        if (s.length() != t.length()) {
            return false;
        }
        // 用长度为26的数组统计每个字符的出现次数（仅小写字母）
        int[] count = new int[26];
        // 遍历第一个字符串，统计字符出现次数
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        // 遍历第二个字符串，减去字符出现次数
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        // 检查所有字符的计数是否为0
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    // 测试方法
    public static void main(String[] args) {
        Q0242_ValidAnagram solution = new Q0242_ValidAnagram();
        
        // 示例 1
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("示例 1 输出: " + solution.isAnagram(s1, t1)); // 应输出 true
        
        // 示例 2
        String s2 = "rat";
        String t2 = "car";
        System.out.println("示例 2 输出: " + solution.isAnagram(s2, t2)); // 应输出 false
    }
}
