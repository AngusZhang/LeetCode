package club.movon.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * @author zhangzhipeng
 * @date 2019-01-21
 */
public class SolutionLinkedListCycleTwo {
    
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
    
        while (p != null) {
            if (p.next != null && set.contains(p.next)) {
                return p.next;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }
}
