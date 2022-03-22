package com.winston.linkedlist;

import com.winston.linkedlist.domain.ListNode;

import java.util.Objects;

public class AddTwoNumbers2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointResult = null, resultHead = null;
        int carry = 0;

        while(Objects.nonNull(l1) || Objects.nonNull(l2)){
            ListNode sumNode = new ListNode();
            int l1Val = Objects.isNull(l1)? 0 : l1.val;
            int l2Val = Objects.isNull(l2)? 0 : l2.val;
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            sum = sum % 10;
            sumNode.val = sum;
            if (Objects.isNull(pointResult)){
                pointResult = sumNode;
                resultHead = pointResult;
            }else {
                pointResult.next = sumNode;
            }
            pointResult = sumNode;
            if (Objects.nonNull(l1)){
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)){
                l2 = l2.next;
            }
        }
        if (carry > 0){
            pointResult.next = new ListNode(carry);
        }
        return resultHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
        ListNode result = addTwoNumbers2.addTwoNumbers(l1, l2);
        LinkedListUtils.printList(result);
    }


}
