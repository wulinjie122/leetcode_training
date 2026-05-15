package com.leetcode.string;

import java.util.Stack;

/**
 * 最长有效括号子串
 * 问题：找到字符串中最长的有效括号子串的长度
 * 解法：提供了三种方法：动态规划、栈、左右扫描
 */
public class Q0032_LongestValidParentheses {
    /**
     * 方法一：动态规划
     * 思路：使用dp数组，其中dp[i]表示以第i个字符结尾的最长有效括号子串的长度
     * @param s 输入字符串
     * @return 最长有效括号子串的长度
     */
    public int longestValidParentheses1(String s) {
        // 存储最长有效括号子串的长度
        int maxLen = 0;
        // dp数组，dp[i]表示以第i个字符结尾的最长有效括号子串的长度
        int[] dp = new int[s.length()];
        
        // 从第二个字符开始遍历
        for (int i = 1; i < s.length(); i++) {
            // 只有遇到右括号时才需要处理
            if (s.charAt(i) == ')') {
                // 如果前一个字符是左括号，那么形成一个有效对
                if (s.charAt(i - 1) == '(') {
                    // 长度为2加上前前一个位置的最长有效长度
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } 
                // 如果前一个字符是右括号，需要检查前面是否有对应的左括号
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 长度为前一个有效长度加上当前有效对的长度，再加上前面可能的有效长度
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                // 更新最长有效长度
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        
        return maxLen;
    }
    
    /**
     * 方法二：栈
     * 思路：使用栈存储索引，栈底元素为最后一个未被匹配的右括号的索引
     * @param s 输入字符串
     * @return 最长有效括号子串的长度
     */
    public int longestValidParentheses2(String s) {
        // 存储最长有效括号子串的长度
        int maxLen = 0;
        // 创建栈，用于存储索引
        Stack<Integer> stack = new Stack<>();
        // 初始时压入-1作为栈底元素
        stack.push(-1);
        
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // 如果是左括号，压入索引
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 如果是右括号，弹出栈顶元素
                stack.pop();
                // 检查栈是否为空
                if (stack.isEmpty()) {
                    // 栈为空，说明当前右括号未被匹配，压入当前索引作为新的栈底元素
                    stack.push(i);
                } else {
                    // 栈不为空，计算当前有效子串的长度
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
    
    /**
     * 方法三：左右扫描
     * 思路：分别从左到右和从右到左扫描，记录左右括号的数量
     * @param s 输入字符串
     * @return 最长有效括号子串的长度
     */
    public int longestValidParentheses3(String s) {
        // 左右括号计数器和最长有效长度
        int left = 0, right = 0, maxLen = 0;
        
        // 从左到右扫描
        for (int i = 0; i < s.length(); i++) {
            // 遇到左括号，左计数器加1
            if (s.charAt(i) == '(') {
                left++;
            } else {
                // 遇到右括号，右计数器加1
                right++;
            }
            // 左右计数器相等，更新最长有效长度
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                // 右括号数量超过左括号，重置计数器
                left = right = 0;
            }
        }
        
        // 重置计数器，准备从右到左扫描
        left = right = 0;
        // 从右到左扫描
        for (int i = s.length() - 1; i >= 0; i--) {
            // 遇到左括号，左计数器加1
            if (s.charAt(i) == '(') {
                left++;
            } else {
                // 遇到右括号，右计数器加1
                right++;
            }
            // 左右计数器相等，更新最长有效长度
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                // 左括号数量超过右括号，重置计数器
                left = right = 0;
            }
        }
        
        return maxLen;
    }
}