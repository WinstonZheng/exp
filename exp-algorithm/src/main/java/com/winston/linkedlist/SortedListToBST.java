package com.winston.linkedlist;

import com.winston.linkedlist.domain.ListNode;
import com.winston.linkedlist.domain.TreeNode;

import java.util.Objects;

public class SortedListToBST {

    /**
     * 算法可以进一步优化找中位数这步操作
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(Objects.isNull(head)){
            return null;
        }
        if(Objects.isNull(head.next)){
            return new TreeNode(head.val, null, null);
        }
        ListNode midPrevNode = findMidPrev(head);
        ListNode midNode = midPrevNode.next;
        midPrevNode.next = null;
        TreeNode leftSubTree = sortedListToBST(head);
        TreeNode rightSubTree = sortedListToBST(midNode.next);
        TreeNode nowTreeNode = new TreeNode(midNode.val, leftSubTree, rightSubTree);
        return nowTreeNode;
    }



    private ListNode findMidPrev(ListNode head){
        ListNode slowPoint = head, fastPoint = head;
        while(Objects.nonNull(fastPoint.next) &&
                Objects.nonNull(fastPoint.next.next) &&
                Objects.nonNull(fastPoint.next.next.next) &&
                Objects.nonNull(fastPoint.next.next.next.next)){
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
        }
        return slowPoint;
    }

    ListNode globalHead;

    /**
     * 通过中序遍历的方式，
     * 1、通过中序遍历方式建树；
     * 2、在建树过程中，顺序遍历链表，可以获得每次建树的节点值；
     * 二叉搜索树中序遍历结果，就是排序链表（从小到大）
     * @param head
     * @return
     */
    public TreeNode sortedListToBSTBetter(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }


}
