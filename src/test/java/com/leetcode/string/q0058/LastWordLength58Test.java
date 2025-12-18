package com.leetcode.string.q0058;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LastWordLength58 的测试类
 */
public class LastWordLength58Test {

    @Test
    public void testLengthOfLastWord_基本测试用例() {
        LastWordLength58 solution = new LastWordLength58();
        
        // 测试用例1：普通情况
        String s1 = "Hello World";
        int result1 = solution.lengthOfLastWord(s1);
        assertEquals(5, result1);
    }

    @Test
    public void testLengthOfLastWord_末尾有空格() {
        LastWordLength58 solution = new LastWordLength58();
        
        // 测试用例2：末尾有多个空格
        String s2 = "   fly me   to   the moon  ";
        int result2 = solution.lengthOfLastWord(s2);
        assertEquals(4, result2);
    }

    @Test
    public void testLengthOfLastWord_单个单词() {
        LastWordLength58 solution = new LastWordLength58();
        
        // 测试用例3：单个单词
        String s3 = "luffy is still joyboy";
        int result3 = solution.lengthOfLastWord(s3);
        assertEquals(6, result3);
    }

    @Test
    public void testLengthOfLastWord_边界情况() {
        LastWordLength58 solution = new LastWordLength58();
        
        // 测试用例4：空字符串
        String s4 = "";
        int result4 = solution.lengthOfLastWord(s4);
        assertEquals(0, result4);
        
        // 测试用例5：null字符串
        String s5 = null;
        int result5 = solution.lengthOfLastWord(s5);
        assertEquals(0, result5);
        
        // 测试用例6：只有空格
        String s6 = "   ";
        int result6 = solution.lengthOfLastWord(s6);
        assertEquals(0, result6);
    }

    @Test
    public void testLengthOfLastWord_单字符单词() {
        LastWordLength58 solution = new LastWordLength58();
        
        // 测试用例7：单字符单词
        String s7 = "a";
        int result7 = solution.lengthOfLastWord(s7);
        assertEquals(1, result7);
    }

    @Test
    public void testLengthOfLastWordSplit_使用split方法() {
        LastWordLength58 solution = new LastWordLength58();
        
        // 测试split方法
        String s = "Hello World";
        int result = solution.lengthOfLastWordSplit(s);
        assertEquals(5, result);
    }

    @Test
    public void testLengthOfLastWordOptimized_优化版本() {
        LastWordLength58 solution = new LastWordLength58();
        
        // 测试优化版本
        String s = "   fly me   to   the moon  ";
        int result = solution.lengthOfLastWordOptimized(s);
        assertEquals(4, result);
    }
}
