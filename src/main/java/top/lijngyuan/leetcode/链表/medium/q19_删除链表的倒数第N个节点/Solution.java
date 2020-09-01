package top.lijngyuan.leetcode.链表.medium.q19_删除链表的倒数第N个节点;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针
// 👍 967 👎 0

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-01
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = removeNthFromEnd(node1, 5);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    /**
     * 让前面的指针先移动n步，之后前后指针共同移动直到前面的指针到尾部为止
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre, slow = pre;
        while (n > 0) {
            // fast 先向前移动n步
            fast = fast.next;
            n--;
        }
        // 之后 fast 和 slow 共同向前移动，此时二者的距离为 n，当 fast 到尾部时，slow 的位置恰好为倒数第 n 个节点
        while (fast.next != null) {
            fast = fast.next;
            // 找到要删除节点的前驱节点,要移动到该节点的前一个才能删除，
            slow = slow.next;
        }
        slow.next = slow.next.next;
        // 不返回head，因为 head 有可能是被删掉的点
        return pre.next;
    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
