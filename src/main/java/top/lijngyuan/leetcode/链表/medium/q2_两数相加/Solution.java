package top.lijngyuan.leetcode.链表.medium.q2_两数相加;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
// 👍 4849 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-07
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(3);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        // (2 -> 4 -> 3) + (5 -> 6 -> 4) ==> 7 -> 0 -> 8
        // 342 + 465 = 807
        ListNode node = addTwoNumbers(node11, node21);
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode preHead = new ListNode(-1);
        ListNode current = preHead;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return preHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}