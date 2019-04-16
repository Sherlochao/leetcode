package linkedlist;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next || k < 1) {
            return head;
        }
        int len = 0;
        ListNode tmp = head;
        while (null != tmp) {
            len++;
            tmp = tmp.next;
        }
        if (k % len == 0) {
            return head;
        }
        tmp = head;
        int i = len - k % len;
        while (i != 1) {
            i--;
            tmp = tmp.next;
        }
        ListNode newHead = tmp.next;
        ListNode last = tmp;
        last.next = null;
        tmp = newHead;
        while (null != tmp.next) {
            tmp = tmp.next;
        }
        tmp.next = head;
        return newHead;
    }
}
