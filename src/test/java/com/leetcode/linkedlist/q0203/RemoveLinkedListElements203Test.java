package com.leetcode.linkedlist.q0203;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 测试类：RemoveLinkedListElements203的测试用例
 */
public class RemoveLinkedListElements203Test {

    private final RemoveLinkedListElements203 solution = new RemoveLinkedListElements203();

    /**
     * 创建链表的辅助方法
     */
    private ListNode createLinkedList(int[] values) {
        if (values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * 验证链表内容的辅助方法
     */
    private void assertLinkedListEquals(ListNode head, int[] expectedValues) {
        ListNode current = head;
        int index = 0;
        while (current != null && index < expectedValues.length) {
            assertEquals("链表节点值不匹配", expectedValues[index], current.val);
            current = current.next;
            index++;
        }
        assertNull("链表长度超出预期", current);
        assertEquals("链表长度不足", expectedValues.length, index);
    }

    /**
     * 示例1测试：常规情况
     */
    @Test
    public void testRemoveElements_Example1() {
        // 示例1：输入：head = [1,2,6,3,4,5,6], val = 6
        // 输出：[1,2,3,4,5]
        int[] input = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        int[] expected = {1, 2, 3, 4, 5};
        
        ListNode head = createLinkedList(input);
        
        // 测试递归解法
        ListNode result1 = solution.removeElements_recursive(head, val);
        assertLinkedListEquals(result1, expected);
        
        // 重新创建链表进行测试
        head = createLinkedList(input);
        
        // 测试迭代解法
        ListNode result2 = solution.removeElements(head, val);
        assertLinkedListEquals(result2, expected);
        
        // 重新创建链表进行测试
        head = createLinkedList(input);
        
        // 测试虚拟头节点解法
        ListNode result3 = solution.removeElements_dummyNode(head, val);
        assertLinkedListEquals(result3, expected);
    }

    /**
     * 示例2测试：空链表
     */
    @Test
    public void testRemoveElements_Example2() {
        // 示例2：输入：head = [], val = 1
        // 输出：[]
        int[] input = {};
        int val = 1;
        int[] expected = {};
        
        ListNode head = createLinkedList(input);
        
        // 测试递归解法
        ListNode result1 = solution.removeElements_recursive(head, val);
        assertLinkedListEquals(result1, expected);
        
        // 测试迭代解法
        ListNode result2 = solution.removeElements(head, val);
        assertLinkedListEquals(result2, expected);
        
        // 测试虚拟头节点解法
        ListNode result3 = solution.removeElements_dummyNode(head, val);
        assertLinkedListEquals(result3, expected);
    }

    /**
     * 示例3测试：所有节点都要删除
     */
    @Test
    public void testRemoveElements_Example3() {
        // 示例3：输入：head = [7,7,7,7], val = 7
        // 输出：[]
        int[] input = {7, 7, 7, 7};
        int val = 7;
        int[] expected = {};
        
        ListNode head = createLinkedList(input);
        
        // 测试递归解法
        ListNode result1 = solution.removeElements_recursive(head, val);
        assertLinkedListEquals(result1, expected);
        
        // 重新创建链表进行测试
        head = createLinkedList(input);
        
        // 测试迭代解法
        ListNode result2 = solution.removeElements(head, val);
        assertLinkedListEquals(result2, expected);
        
        // 重新创建链表进行测试
        head = createLinkedList(input);
        
        // 测试虚拟头节点解法
        ListNode result3 = solution.removeElements_dummyNode(head, val);
        assertLinkedListEquals(result3, expected);
    }

    /**
     * 边界情况：头节点需要删除
     */
    @Test
    public void testRemoveElements_HeadRemoval() {
        // 测试头节点需要删除的情况
        int[] input = {6, 1, 2, 3};
        int val = 6;
        int[] expected = {1, 2, 3};
        
        ListNode head = createLinkedList(input);
        
        // 测试递归解法
        ListNode result1 = solution.removeElements_recursive(head, val);
        assertLinkedListEquals(result1, expected);
        
        // 重新创建链表进行测试
        head = createLinkedList(input);
        
        // 测试迭代解法
        ListNode result2 = solution.removeElements(head, val);
        assertLinkedListEquals(result2, expected);
        
        // 重新创建链表进行测试
        head = createLinkedList(input);
        
        // 测试虚拟头节点解法
        ListNode result3 = solution.removeElements_dummyNode(head, val);
        assertLinkedListEquals(result3, expected);
    }

    /**
     * 边界情况：尾节点需要删除
     */
    @Test
    public void testRemoveElements_TailRemoval() {
        // 测试尾节点需要删除的情况
        int[] input = {1, 2, 3, 6};
        int val = 6;
        int[] expected = {1, 2, 3};
        
        ListNode head = createLinkedList(input);
        
        // 测试递归解法
        ListNode result1 = solution.removeElements_recursive(head, val);
        assertLinkedListEquals(result1, expected);
        
        // 重新创建链表进行测试
        head = createLinkedList(input);
        
        // 测试迭代解法
        ListNode result2 = solution.removeElements(head, val);
        assertLinkedListEquals(result2, expected);
        
        // 重新创建链表进行测试
        head = createLinkedList(input);
        
        // 测试虚拟头节点解法
        ListNode result3 = solution.removeElements_dummyNode(head, val);
        assertLinkedListEquals(result3, expected);
    }

    /**
     * 边界情况：没有节点需要删除
     */
    @Test
    public void testRemoveElements_NoRemoval() {
        // 测试没有节点需要删除的情况
        int[] input = {1, 2, 3, 4, 5};
        int val = 6;
        int[] expected = {1, 2, 3, 4, 5};
        
        ListNode head = createLinkedList(input);
        
        // 测试递归解法
        ListNode result1 = solution.removeElements_recursive(head, val);
        assertLinkedListEquals(result1, expected);
        
        // 重新创建链表进行测试
        head = createLinkedList(input);
        
        // 测试迭代解法
        ListNode result2 = solution.removeElements(head, val);
        assertLinkedListEquals(result2, expected);
        
        // 重新创建链表进行测试
        head = createLinkedList(input);
        
        // 测试虚拟头节点解法
        ListNode result3 = solution.removeElements_dummyNode(head, val);
        assertLinkedListEquals(result3, expected);
    }

    /**
     * 边界情况：单节点链表
     */
    @Test
    public void testRemoveElements_SingleNode() {
        // 测试单节点链表需要删除的情况
        int[] input1 = {6};
        int val1 = 6;
        int[] expected1 = {};
        
        ListNode head1 = createLinkedList(input1);
        
        // 测试递归解法
        ListNode result1 = solution.removeElements_recursive(head1, val1);
        assertLinkedListEquals(result1, expected1);
        
        // 测试单节点链表不需要删除的情况
        int[] input2 = {5};
        int val2 = 6;
        int[] expected2 = {5};
        
        ListNode head2 = createLinkedList(input2);
        
        // 测试迭代解法
        ListNode result2 = solution.removeElements(head2, val2);
        assertLinkedListEquals(result2, expected2);
    }
}