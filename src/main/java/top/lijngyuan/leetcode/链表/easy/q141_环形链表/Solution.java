package top.lijngyuan.leetcode.链表.easy.q141_环形链表;
//给定一个链表，判断链表中是否有环。
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
//
//
// 示例 1：
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
//
//
// 示例 2：
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
//
//
// 示例 3：
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
//
//
//
//
//
//
// 进阶：
//
// 你能用 O(1)（即，常量）内存解决此问题吗？
// Related Topics 链表 双指针
// 👍 739 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-07
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        boolean cycle = hasCycle(node1);
        System.out.println(cycle);
    }

    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
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
