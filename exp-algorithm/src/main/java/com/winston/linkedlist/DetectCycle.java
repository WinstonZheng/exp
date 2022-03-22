package com.winston.linkedlist;

import com.winston.linkedlist.domain.ListNode;

import java.util.Objects;

public class DetectCycle {

    /**
     * 检测链表是否存在环
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/submissions/
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(Objects.nonNull(fast)){
            if(Objects.isNull(fast.next)){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }




}
