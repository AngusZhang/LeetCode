package club.movon.leetcode.solutions;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *
 * @author zhangzhipeng
 * @date 2019-01-05
 */
public class SolutionAddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode result = new ListNode(0);
        ListNode pre = result;
        ListNode curr = result;
        while (node1 != null || node2 != null) {
            int val1 = node1 != null ? node1.val : 0;
            int val2 = node2 != null ? node2.val : 0;

            if (curr == null) {
                curr = new ListNode(0);
                pre.next = curr;
            }

            int val = val1 + val2 + curr.val;
            int carry = 0;
            if (val >= 10) {
                val -= 10;
                carry = 1;
            }

            curr.val = val;

            if (carry > 0) {
                curr.next = new ListNode(carry);
            }

            pre = curr;
            curr = curr.next;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }

        }

        return result;
    }

    /**
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param args
     */

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        SolutionAddTwoNumbers solutionAddTwoNumbers = new SolutionAddTwoNumbers();
        ListNode listNode = solutionAddTwoNumbers.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.printf(String.valueOf(listNode.val));
            listNode = listNode.next;
        }
    }
}
