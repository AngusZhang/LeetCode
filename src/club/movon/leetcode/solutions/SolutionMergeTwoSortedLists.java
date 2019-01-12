package club.movon.leetcode.solutions;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author zhangzhipeng
 * @date 2019/1/12
 */
public class SolutionMergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode pcur = dummyHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (true) {
            if (p1 == null) {
                pcur.next = p2;
                break;
            } else if (p2 == null) {
                pcur.next = p1;
                break;
            } else {
                if (p1.val > p2.val) {
                    pcur.next = p2;
                    p2 = p2.next;
                } else {
                    pcur.next = p1;
                    p1 = p1.next;
                }
            }
            pcur = pcur.next;
        }
        return dummyHead.next;
    }
}
