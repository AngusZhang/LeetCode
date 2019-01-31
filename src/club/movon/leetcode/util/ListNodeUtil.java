package club.movon.leetcode.util;

import club.movon.leetcode.solutions.ListNode;

import java.util.Arrays;

/**
 * @author zhangzhipeng
 * @date 2019-01-31
 */
public final class ListNodeUtil {
    
    public static ListNode buildList(int[] nums) {
        ListNode dummyHead = new ListNode(-1);
        Arrays.stream(nums).mapToObj(ListNode::new)
                .reduce(dummyHead, (node1, node2) -> {
                    node1.next = node2;
                    return node2;
                });
        
        return dummyHead.next;
    }
    
    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    
    public static void main(String[] args) {
        ListNode listNode = buildList(new int[]{1, 2, 3, 4, 5});
        printList(listNode);
    }
}
