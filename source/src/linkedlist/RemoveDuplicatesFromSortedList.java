package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    public static class ListNode {
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
        Set<Integer> set = new HashSet<>();
        ListNode cur = head.next;
        ListNode pre = head;
        set.add(head.val);
        while (null != cur) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
