package com.person.leetcode2;

import java.util.List;
import java.util.Optional;

public class Solution1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode firstNode = new ListNode();
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode flowNode = firstNode;

        while (list1 != null || list2 != null) {
            int num1 = list1 != null ? list1.val : 0;
            int num2 = list2 != null ? list2.val : 0;
            int sum = num1 + num2 + carry;

            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;

            flowNode.next = node;
            flowNode = node;

            list1 = list1 != null ? list1.next : null;
            list2 = list2 != null ? list2.next : null;
        }

        if (carry > 0) {
            flowNode.next = new ListNode(carry);
        }

        return firstNode.next;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3))); // 342
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4))); // 465
        ListNode l3 = solution1.addTwoNumbers(l1, l2);

        for (ListNode loop = l3; Optional.ofNullable(loop).isPresent(); loop = loop.next) { // 807
            System.out.print(loop.val);
        }
    }
}
