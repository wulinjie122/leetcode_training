package com.leetcode.string;

import org.junit.Test;
import static org.junit.Assert.*;

public class Q0032_LongestValidParenthesesTest {
    
    private Q0032_LongestValidParentheses solution = new Q0032_LongestValidParentheses();
    
    @Test
    public void testLongestValidParentheses() {
        assertEquals(2, solution.longestValidParentheses1("(()"));
        assertEquals(4, solution.longestValidParentheses1(")()())"));
        assertEquals(0, solution.longestValidParentheses1(""));
        assertEquals(6, solution.longestValidParentheses1("()(()))"));
        
        assertEquals(2, solution.longestValidParentheses2("(()"));
        assertEquals(4, solution.longestValidParentheses2(")()())"));
        assertEquals(0, solution.longestValidParentheses2(""));
        assertEquals(6, solution.longestValidParentheses2("()(()))"));
        
        assertEquals(2, solution.longestValidParentheses3("(()"));
        assertEquals(4, solution.longestValidParentheses3(")()())"));
        assertEquals(0, solution.longestValidParentheses3(""));
        assertEquals(6, solution.longestValidParentheses3("()(()))"));
    }
}