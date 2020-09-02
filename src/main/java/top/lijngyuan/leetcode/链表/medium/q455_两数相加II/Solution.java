package top.lijngyuan.leetcode.链表.medium.q455_两数相加II;
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
//
//
// 进阶：
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
//
//
//
// 示例：
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
//
// Related Topics 链表
// 👍 267 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-02
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node11 = new ListNode(7);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(4);
        ListNode node14 = new ListNode(3);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;
        ListNode head = addTwoNumbers(node11, node21);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1);
            l1 = l1.next;
        }
        Stack<ListNode> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.add(l2);
            l2 = l2.next;
        }
        ListNode preHead = new ListNode(-1);
        // {5} , {5} = {1,0} 这种 , carry 在 0 1 之间切换
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int node1Val = stack1.isEmpty() ? 0 : stack1.pop().val;
            int node2Val = stack2.isEmpty() ? 0 : stack2.pop().val;
            int val = node1Val + node2Val + carry;
            carry = val / 10;
            ListNode node = new ListNode(val % 10);
            // 头插法
            node.next = preHead.next;
            preHead.next = node;
        }
        return preHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
