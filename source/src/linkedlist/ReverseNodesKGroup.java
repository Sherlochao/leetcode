package linkedlist;

import java.util.Stack;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 示例 :
 *      给定这个链表：1->2->3->4->5
 *      当 k = 2 时，应当返回: 2->1->4->3->5
 *      当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReverseNodesKGroup {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (null != cur) {
            next = cur.next;
            stack.push(cur);
            if (k == stack.size()) {
                pre = resign(stack, pre, next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    private static ListNode resign(Stack<ListNode> stack, ListNode left, ListNode right) {
        ListNode cur = stack.pop();
        if (null != left) {
            left.next = cur;
        }
        ListNode next;
        while (!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    public static void main(String[] args) throws Exception {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode result = new ReverseNodesKGroup().reverseKGroup(node, 2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
