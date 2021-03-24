package top.lijngyuan.leetcode.链表.medium.q92_反转链表II;
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
//
//
// 示例 2：
//
//
//输入：head = [5], left = 1, right = 1
//输出：[5]
//
//
//
//
// 提示：
//
//
// 链表中节点数目为 n
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
//
//
//
//
// 进阶： 你可以使用一趟扫描完成反转吗？
// Related Topics 链表
// 👍 831 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * q92 solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2021-03-23
 * @since 1.0.0
 */
public class Q92Solution {

    public static void main(String[] args) {
        // 1 2 3 4 5
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
//        ListNode reversedHead = reverse2(head);
//        reversedHead.print();
//        reverseN(head, 3);
        ListNode reversedHead = reverseBetween(head, 2, 4);
        // 1->4->3->2->5
        reversedHead.print();
    }

    public static ListNode reverseN2(ListNode head, int n) {
        ListNode newHead = new ListNode();
        ListNode curr = head;
        for (int i = 1; i <= n; i++) {
            ListNode next = curr.next;
            curr.next = newHead.next;
            newHead.next = curr;
            curr = next;
        }
        head.next = curr;
        return newHead.next;
    }

    // 后驱节点
    static ListNode successor = null;

    /**
     * 反转以 head 为起点的 n 个节点，返回新的头结点
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6
     * n = 3
     * 最后要求是：
     * 3 -> 2 -> 1 -> 4 -> 5 -> 6
     */
    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点，递归到这里，要保存下来，这里就是 4 节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        // 这里 last 就是 2 节点 2 -> 1
        // 分成 head [last] 两部分
        ListNode last = reverseN(head.next, n - 1);
        // 把 [last]的最后一个节点的next置为head
        head.next.next = head;
        // 1 的 next 设置为 4，把原来的head（现在倒转过来的链表的最后一个节点）的 next 接上原来的正序的部分链表
        head.next = successor;
        return last;
    }

    /**
     * 输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
     */
    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        // head：1 -> 2 -> 3 -> 4 -> 5
        // head：1 -> 2 <- 3 <- 4 <- 5(last)
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reveredHeadAssist = new ListNode();
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            // head：1 2 3 4 5
            // 0 2 1
            curr.next = reveredHeadAssist.next;
            reveredHeadAssist.next = curr;
            curr = next;
        }
        return reveredHeadAssist.next;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            // 相当于反转前 n 个元素
            return reverseN(head, right);
        }
        // 如果 m != 1 怎么办？如果我们把 head 的索引视为 1，那么我们是想从第 m 个元素开始反转对吧；
        // 如果把 head.next 的索引视为 1 呢？那么相对于 head.next，反转的区间应该是从第 m - 1 个元素开始的；
        // 那么对于 head.next.next 呢……
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
