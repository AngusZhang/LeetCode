package club.movon.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * @author zhangzhipeng
 * @date 2019-01-18
 */
public class SolutionLinkedListCycle {
    
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        
        while (p != null) {
            if (p.next != null && set.contains(p.next)) {
                return true;
            }
            set.add(p);
            p = p.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        
    }
}
