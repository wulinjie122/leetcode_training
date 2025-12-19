package com.leetcode.string;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Q0014_LongestCommonPrefix 的测试类
 */
public class Q0014_LongestCommonPrefixTest {

    @Test
    public void testLongestCommonPrefix_基本测试用例() {
        Q0014_LongestCommonPrefix solution = new Q0014_LongestCommonPrefix();
        
        // 测试用例1：有公共前缀
        String[] strs1 = {"flower", "flow", "flight"};
        String result1 = solution.longestCommonPrefix(strs1);
        assertEquals("fl", result1);
    }

    @Test
    public void testLongestCommonPrefix_无公共前缀() {
        Q0014_LongestCommonPrefix solution = new Q0014_LongestCommonPrefix();
        
        // 测试用例2：无公共前缀
        String[] strs2 = {"dog", "racecar", "car"};
        String result2 = solution.longestCommonPrefix(strs2);
        assertEquals("", result2);
    }

    @Test
    public void testLongestCommonPrefix_空数组() {
        Q0014_LongestCommonPrefix solution = new Q0014_LongestCommonPrefix();
        
        // 测试用例3：空数组
        String[] strs3 = {};
        String result3 = solution.longestCommonPrefix(strs3);
        assertEquals("", result3);
        
        // 测试用例4：null数组
        String[] strs4 = null;
        String result4 = solution.longestCommonPrefix(strs4);
        assertEquals("", result4);
    }

    @Test
    public void testLongestCommonPrefix_单元素数组() {
        Q0014_LongestCommonPrefix solution = new Q0014_LongestCommonPrefix();
        
        // 测试用例5：单元素数组
        String[] strs5 = {"hello"};
        String result5 = solution.longestCommonPrefix(strs5);
        assertEquals("hello", result5);
    }

    @Test
    public void testLongestCommonPrefix_相同字符串() {
        Q0014_LongestCommonPrefix solution = new Q0014_LongestCommonPrefix();
        
        // 测试用例6：所有字符串相同
        String[] strs6 = {"test", "test", "test"};
        String result6 = solution.longestCommonPrefix(strs6);
        assertEquals("test", result6);
    }

    @Test
    public void testLongestCommonPrefixVertical_纵向扫描() {
        Q0014_LongestCommonPrefix solution = new Q0014_LongestCommonPrefix();
        
        // 测试纵向扫描方法
        String[] strs = {"flower", "flow", "flight"};
        String result = solution.longestCommonPrefixVertical(strs);
        assertEquals("fl", result);
    }

    @Test
    public void testLongestCommonPrefixDivide_分治法() {
        Q0014_LongestCommonPrefix solution = new Q0014_LongestCommonPrefix();
        
        // 测试分治法
        String[] strs = {"interspecies", "interstellar", "interstate"};
        String result = solution.longestCommonPrefixDivide(strs);
        assertEquals("inters", result);
    }
}
