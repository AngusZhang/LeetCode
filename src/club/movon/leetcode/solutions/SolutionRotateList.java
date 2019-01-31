package club.movon.leetcode.solutions;

import club.movon.leetcode.util.ListNodeUtil;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * @author zhangzhipeng
 * @date 2019-01-31
 */
public class SolutionRotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        int len = 1;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        p.next = head;
        
        int i = len - k % len;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        ListNode result = p.next;
        p.next = null;
        
        return result;
    }
    
    public static void main(String[] args) {
        SolutionRotateList solution = new SolutionRotateList();
        ListNode listNode = ListNodeUtil.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.rotateRight(listNode, 2);
        ListNodeUtil.printList(result);
        
        System.out.println("---------");
        listNode = ListNodeUtil.buildList(new int[]{0, 1, 2});
        result = solution.rotateRight(listNode, 4);
        ListNodeUtil.printList(result);
    }
}
