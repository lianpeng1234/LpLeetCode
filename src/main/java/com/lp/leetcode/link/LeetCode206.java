package com.lp.leetcode.link;

public class LeetCode206 {

//    输入:       1->2->3->4->5->NULL
//    输出: NULL<-1<-2<-3<-4<-5
    // 1->2->3->4->5->NULL
    // NULL<-1->2->3->4->5->NULL

    // 1<-2  3->4->5
    // 1<-2<-3 4->5
    // 1<-2<-3<-4 5
    // 1<-2<-3<-4<-5

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;// 2 3

            cur.next = pre;// null<-1<-2

            pre = cur;// 1 2

            cur = tmp;// 2 3

        }
        return pre;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}



