package com.winston.linkedlist;
import com.winston.linkedlist.domain.ListNode;

import java.util.Objects;

public class Main {


    /**
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (Objects.isNull(head)){
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fisrt = dummyNode, last = dummyNode;
        for (int i = 0; i < n; i++) {
            last = last.next;
            if (Objects.isNull(last)){
                return head;
            }
        }
        while (Objects.nonNull(last.next)){
            fisrt = fisrt.next;
            last = last.next;
        }
        fisrt.next = fisrt.next.next;
        return dummyNode.next;
    }


    public static void main(String[] args) {
//        ListNode head = new ListNode(2, new ListNode(3));
//        ListNode finalNode = LinkedListUtils.getFinalNode(head);
//        System.out.println(finalNode.getVal());
//        System.out.println(head.getVal());

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("hhehe");
                continue;
            }finally {
                System.out.println("haha");
            }
        }

    }
}
