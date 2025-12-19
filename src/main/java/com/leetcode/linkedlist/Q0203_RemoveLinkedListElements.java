package com.leetcode.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * LeetCode 203. 移除链表元素
 * 
 * 题目描述：
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * 
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * 
 * 解题思路：
 * 1. 递归解法：递归地处理链表中的每个节点
 * 2. 迭代解法：使用指针遍历链表，跳过值为val的节点
 */
public class Q0203_RemoveLinkedListElements {

    /**
     * 方法1：递归解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n) - 递归调用栈的深度
     */
    public ListNode removeElements_recursive(ListNode head, int val) {
        // 基本情况：链表为空，直接返回null
        if (head == null) {
            return null;
        }
        
        // 递归处理下一个节点
        head.next = removeElements_recursive(head.next, val);
        
        // 如果当前节点的值等于val，则返回下一个节点（跳过当前节点）
        // 否则返回当前节点
        return head.val == val ? head.next : head;
    }

    /**
     * 方法2：迭代解法（推荐）
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        // 处理头节点可能等于val的情况
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        // 如果链表为空，直接返回null
        if (head == null) {
            return null;
        }
        
        // 遍历链表，跳过值为val的节点
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                // 跳过下一个节点
                current.next = current.next.next;
            } else {
                // 移动到下一个节点
                current = current.next;
            }
        }
        
        return head;
    }
    
    /**
     * 方法3：使用虚拟头节点的迭代解法
     * 这种方法可以统一处理头节点和其他节点的情况
     */
    public ListNode removeElements_dummyNode(ListNode head, int val) {
        // 创建虚拟头节点，指向原链表的头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // 使用指针遍历链表
        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val == val) {
                // 跳过下一个节点
                current.next = current.next.next;
            } else {
                // 移动到下一个节点
                current = current.next;
            }
        }
        
        return dummy.next;
    }
}