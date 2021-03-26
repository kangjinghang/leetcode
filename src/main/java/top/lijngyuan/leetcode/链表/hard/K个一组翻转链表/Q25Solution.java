package top.lijngyuan.leetcode.链表.hard.K个一组翻转链表;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 进阶：
//
//
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
//
//
// 示例 3：
//
//
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
//
//
// 示例 4：
//
//
//输入：head = [1], k = 1
//输出：[1]
//
//
//
//
//
// 提示：
//
//
// 列表中节点的数量在范围 sz 内
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz
//
// Related Topics 链表
// 👍 997 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * q25 solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2021-03-26
 * @since 1.0.0
 */
public class Q25Solution {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
//        ListNode reversedHead = reverse(head, node3);
        ListNode reversedHead = reverseKGroup(head, 2);
//        ListNode reversedHead = reverseKGroup(head, 3);
        reversedHead.print();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        // 反转前 k 个元素，前闭后开，所以 newHead 是 end 的前一个元素
        ListNode newHead = reverse(head, end);
        // 递归反转后续链表并连接起来，head变成末尾节点了
        head.next = reverseKGroup(end, k);
        return newHead;
    }

    public static ListNode reverse(ListNode head) {
        // 用两个指针，pre和next
        ListNode pre, cur, next;
        cur = head;
        pre = null;
        while (cur != null) {
            // 首先暂存为next
            next = cur.next;

            // 赋值
            cur.next = pre;

            // 更新指针位置，继续迭代
            pre = cur;
            cur = next;
        }
        // 返回反转后的头结点
        return pre;
    }

    /**
     * [start, end) 前闭后开，不包含end，相当于截取了链表的前面的一小部分
     */
    public static ListNode reverse(ListNode head, ListNode end) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur != end) {
            next = cur.next;

            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("[");
            sb.append(val);
            sb.append(']');
            return sb.toString();
        }

        void print() {
            System.out.print(this.val);
            ListNode next = this.next;
            while (next != null) {
                System.out.print("->" + next.val);
                next = next.next;
            }
            System.out.println();
        }
    }

}


