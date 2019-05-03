package linkedlist;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class RemoveDuplicatesFromSortedListII {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        boolean flag = false;
        while (null != head) {
            if (null == head.next || head.val != head.next.val) {
                if (flag) {
                    pre.next = head.next;
                } else {
                    pre = head;
                }
                flag = false;
            } else {
                flag = true;
            }
            head = head.next;
        }
        return node.next;
    }
}
