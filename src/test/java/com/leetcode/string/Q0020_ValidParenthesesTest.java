package com.leetcode.string;

import org.junit.Test;
import static org.junit.Assert.*;

public class Q0020_ValidParenthesesTest {
    
    private Q0020_ValidParentheses solution = new Q0020_ValidParentheses();
    
    @Test
    public void testValidParentheses() {
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("()[]{}"));
        assertTrue(solution.isValid("{[]}"));
        assertTrue(solution.isValid("[()()]{}"));
        assertFalse(solution.isValid("([{]})"));
        assertFalse(solution.isValid("(]"));
        assertFalse(solution.isValid("([)]"));
        assertFalse(solution.isValid("("));
        assertFalse(solution.isValid(")"));
    }
}