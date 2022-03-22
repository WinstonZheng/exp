package com.winston.linkedlist;


import com.winston.linkedlist.domain.ListNode;

import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList143 {

    /**
     * 在节点n处，通过距离 N 找到需要迁移的节点迁移到n之后，
     * n=n+2, N=N-2
     * 当N<=1时，结束
     * @param head
     */
    public void reorderList(ListNode head) {
        LinkedListUtils.printList(head);
        ListNode pointer = head;
        int length = (count(head) - 1);
        for (;length > 1;){
            ListNode beforeNeedMoveNode = getMoveNode(pointer, length - 1);
            ListNode needMoveNode = beforeNeedMoveNode.next;
            needMoveNode.next = pointer.next;
            pointer.next = needMoveNode;
            pointer = needMoveNode.next;
            beforeNeedMoveNode.next = null;
            length-=2;
        }
        LinkedListUtils.printList(head);
    }


    private int count(ListNode head){
        ListNode pointer = head;
        if (Objects.isNull(pointer)){
            return 0;
        }
        int count = 1;
        while (pointer.next != null){
            pointer = pointer.next;
            count++;
        }
        return count;
    }

    private ListNode getMoveNode(ListNode start, int step){
        ListNode movePointer = start;
        for (int i = 0; i < step; i++){
            movePointer = movePointer.next;
        }
        return movePointer;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode middle = LinkedListUtils.findMid(head);
        System.out.println(middle.getVal());
    }



    // TODO: 寻找链表中点 + 链表逆序 + 合并链表







}
