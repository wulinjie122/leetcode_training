package com.leetcode.string;

import java.util.Stack;

/**
 * 平衡括号检查
 * 问题：判断字符串中的括号是否平衡，即每个开括号都有对应的闭括号，且顺序正确
 * 解法：使用栈来存储开括号，遇到闭括号时检查栈顶是否匹配
 */
public class Q0020_ValidParentheses {
    /**
     * 检查字符串中的括号是否平衡
     * @param s 输入字符串
     * @return 如果括号平衡返回true，否则返回false
     */
    public boolean isValid(String s) {
        // 创建栈来存储开括号
        Stack<Character> stack = new Stack<>();
        
        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            // 如果是开括号，压入栈中
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 如果是闭括号，检查栈是否为空
                if (stack.isEmpty()) {
                    // 栈为空，说明没有对应的开括号，返回false
                    return false;
                }
                // 弹出栈顶元素
                char top = stack.pop();
                // 检查当前闭括号是否与栈顶开括号匹配
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    // 不匹配，返回false
                    return false;
                }
            }
        }
        
        // 遍历结束后，检查栈是否为空
        // 栈为空说明所有开括号都有对应的闭括号，返回true；否则返回false
        return stack.isEmpty();
    }
}