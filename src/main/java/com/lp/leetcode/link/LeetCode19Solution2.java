package com.lp.leetcode.link;

/**
 * 思路快慢指针
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
 */
public class LeetCode19Solution2 {
    //    1->2->3->4->5, 和 n = 2
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 在对链表进行操作时，一种常用的技巧是添加一个哑节点（dummy node），它的 next 指针指向链表的头节点。这样一来，我们就不需要对头节点进行特殊的判断了。
        // 虽然添加了哑结点，但是代码可读性不好了。
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        int distance = 0;
        while (fast != null) {

            fast = fast.next;

            if (distance <= n) {// 如果是只有 “<” slow 指针就正好落在倒数第 n 个节点上。如果是 “<=” slow 指针就落在倒数第 n+1 个节点上，也就是要删除的节点的前驱节点。
                distance++;
            } else {
                slow = slow.next;
            }
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}



