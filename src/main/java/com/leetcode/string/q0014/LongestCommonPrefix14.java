package com.leetcode.string.q0014;

/**
 * LeetCode 14. 最长公共前缀
 * 
 * 题目描述：
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 
 * 解题思路：
 * 方法1：横向扫描 - 依次比较每个字符串
 * 方法2：纵向扫描 - 按列比较所有字符串的相同位置字符
 * 方法3：分治法 - 将问题分解为子问题
 * 
 * 时间复杂度：O(mn) - m为字符串平均长度，n为字符串数量
 * 空间复杂度：O(1)
 */
public class LongestCommonPrefix14 {

    /**
     * 方法1：横向扫描
     * 依次比较每个字符串，逐步缩小公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 方法2：纵向扫描
     * 按列比较所有字符串的相同位置字符
     */
    public String longestCommonPrefixVertical(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 方法3：分治法
     * 将问题分解为子问题，递归求解
     */
    public String longestCommonPrefixDivide(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        
        int mid = (left + right) / 2;
        String leftPrefix = longestCommonPrefix(strs, left, mid);
        String rightPrefix = longestCommonPrefix(strs, mid + 1, right);
        
        return commonPrefix(leftPrefix, rightPrefix);
    }

    private String commonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, minLength);
    }

    /**
     * 扩展方法：为每个字符串计算它与数组中其他字符串的最大公共前缀
     * 这是原代码中的功能，保留作为扩展
     */
    public String[] findIndividualLCP(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new String[0];
        }

        // 首先找到整个数组的最长公共前缀
        String commonPrefix = longestCommonPrefix(strs);

        // 然后为每个字符串计算它与数组中其他字符串的最大公共前缀
        String[] result = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            result[i] = findMaxPrefixForElement(strs, i, commonPrefix);
        }

        return result;
    }

    private String findMaxPrefixForElement(String[] strs, int index, String commonPrefix) {
        String maxPrefix = "";
        String current = strs[index];

        // 检查当前字符串与公共前缀的关系
        if (current.startsWith(commonPrefix)) {
            return commonPrefix;
        }

        // 如果没有公共前缀，则找出当前字符串与其他字符串的最大前缀
        for (int i = 0; i < strs.length; i++) {
            if (i != index) {
                String temp = commonPrefix(current, strs[i]);
                if (temp.length() > maxPrefix.length()) {
                    maxPrefix = temp;
                }
            }
        }

        return maxPrefix;
    }
}
