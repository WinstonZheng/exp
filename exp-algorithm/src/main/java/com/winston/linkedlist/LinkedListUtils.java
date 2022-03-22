package com.winston.linkedlist;


import com.winston.linkedlist.domain.ListNode;

import java.util.Objects;

public class LinkedListUtils {


    /**
     * 通过快慢指针找中点
     * @param head
     * @return
     */
    public static ListNode findMid(ListNode head){
        if (Objects.isNull(head) || Objects.isNull(head.getNext())){
            return head;
        }
        ListNode quickPoint = head;
        ListNode slowPoint = head;
        while (Objects.nonNull(quickPoint.getNext())
                && Objects.nonNull(quickPoint.getNext().getNext())){
            quickPoint = quickPoint.getNext().getNext();
            slowPoint = slowPoint.getNext();
        }
        return slowPoint;
    }

    public static ListNode reverse(ListNode head){
        if (Objects.isNull(head) || Objects.isNull(head.getNext())){
            return head;
        }
        ListNode prev = null;
        while (Objects.nonNull(head)){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode getFinalNode(ListNode head){
        while (head.getNext() != null){
            head = head.getNext();
        }
        return head;
    }

    public static void printList(ListNode head){
        ListNode po = head;
        if (po != null){
            System.out.print(po.getVal());
        }
        po = head.getNext();
        while (po != null){
            System.out.print("->");
            System.out.print(po.getVal());
            po = po.getNext();
        }
        System.out.println();
    }

    /**
     * 查找两个节点之间的中位数
     * @param left
     * @param right
     * @return
     */
    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
