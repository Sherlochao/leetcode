package linkedlist;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public boolean isPalindrome(ListNode head) {
        if (null != head) {
            Stack<ListNode> stack = new Stack<>();
            ListNode node = head;
            while (null != node) {
                stack.push(node);
                node = node.next;
            }
            node = head;
            while (!stack.isEmpty()) {
                if (node.val != stack.pop().val) {
                    return false;
                }
                node = node.next;
            }
        }
        return true;
    }

    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(n/2)
     */
    public boolean isPalindrome1(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }
        ListNode right = head.next;
        ListNode cur = head;
        while (null != cur.next && null != cur.next.next) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        while (null != right) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
