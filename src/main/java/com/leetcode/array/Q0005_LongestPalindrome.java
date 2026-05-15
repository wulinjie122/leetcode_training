package com.leetcode.array;
public class Q0005_LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // 奇数长度的回文
            int len1 = expandAroundCenter(s, i, i);
            // 偶数长度的回文
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // 输出: "bab" 或 "aba"
        System.out.println(longestPalindrome("cbbd"));  // 输出: "bb"
        System.out.println(longestPalindrome("a"));     // 输出: "a"
        System.out.println(longestPalindrome("ac"));    // 输出: "a" 或 "c"
    }
}