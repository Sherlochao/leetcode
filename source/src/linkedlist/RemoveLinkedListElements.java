package linkedlist;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveLinkedListElements {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (null == head) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;
        dummyNode.next = head;
        while (null != head) {
            if (val == head.val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return dummyNode.next;
    }
}
