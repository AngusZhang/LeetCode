package club.movon.leetcode.solutions;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * @author zhangzhipeng
 * @date 2019/1/12
 */
public class SolutionMergeKLists {

    /**
     * 分治法
     * 每次把需要排序的分割成两份
     * 直到列表最多两个链表，合并后返回
     * <p>
     * 设元素个数为 n
     * 时间复杂度 logk * (n/k)
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }

        if (k == 1) {
            return lists[0];
        }

        return mergePartialLists(lists, 0, k - 1);
    }

    private ListNode mergePartialLists(ListNode[] lists, int start, int end) {
        if (end - start > 1) {
            int n = end - start;
            ListNode part1 = mergePartialLists(lists, start, start + n / 2);
            ListNode part2 = mergePartialLists(lists, start + n / 2 + 1, end);
            return mergeTwo(part1, part2);
        }

        if (end == start) {
            return lists[start];
        }
        return mergeTwo(lists[start], lists[end]);
    }

    private ListNode mergeTwo(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode pcur = dummyHead;
        ListNode p1 = list1;
        ListNode p2 = list2;
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

    /**
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

//        ListNode list1 = new ListNode(-10);
//        list1.next = new ListNode(-9);
//        list1.next.next = new ListNode(-9);
//        list1.next.next.next = new ListNode(-3);
//        list1.next.next.next.next = new ListNode(-1);
//        list1.next.next.next.next.next = new ListNode(-1);
//        list1.next.next.next.next.next.next = new ListNode(0);
//
//        ListNode list2 = new ListNode(-5);
//        ListNode list3 = new ListNode(4);
//        ListNode list4 = new ListNode(-8);
//
//        ListNode list5 = null;
//
//        ListNode list6 = new ListNode(-9);
//        list6.next = new ListNode(-6);
//        list6.next.next = new ListNode(-5);
//        list6.next.next.next = new ListNode(-4);
//        list6.next.next.next.next = new ListNode(-2);
//        list6.next.next.next.next.next = new ListNode(2);
//        list6.next.next.next.next.next.next = new ListNode(3);
//
//        ListNode list7 = new ListNode(-3);
//        list7.next = new ListNode(-3);
//        list7.next.next = new ListNode(-2);
//        list7.next.next.next = new ListNode(-1);
//        list7.next.next.next.next = new ListNode(0);


        ListNode[] listNodes = {list1, list2, list3};

        SolutionMergeKLists solution = new SolutionMergeKLists();
        ListNode listNode = solution.mergeKLists(listNodes);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}
