package com.leetcode.string.q0058;

/**
 * LeetCode 58. 最后一个单词的长度
 * 
 * 题目描述：
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0。
 * 
 * 单词是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是 "World"，长度为 5。
 * 
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是 "moon"，长度为 4。
 * 
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是 "joyboy"，长度为 6。
 * 
 * 解题思路：
 * 方法1：从后往前遍历，跳过末尾空格，然后计算最后一个单词长度
 * 方法2：使用trim()和split()方法
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class LastWordLength58 {

    /**
     * 方法1：从后往前遍历（推荐）
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int length = 0;
        int i = s.length() - 1;
        
        // 跳过末尾的空格
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        // 计算最后一个单词的长度
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }

    /**
     * 方法2：使用trim()和split()方法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n) - 因为split()创建了新数组
     */
    public int lengthOfLastWordSplit(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }
        
        String[] words = s.trim().split("\\s+");
        return words[words.length - 1].length();
    }

    /**
     * 方法3：优化版本 - 从后往前遍历，更简洁的写法
     */
    public int lengthOfLastWordOptimized(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        s = s.trim(); // 去除首尾空格
        int length = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                break;
            }
        }
        
        return length;
    }
}
