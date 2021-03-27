package top.lijngyuan.leetcode.链表.easy.q234_回文链表;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针
// 👍 913 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * q234 solution
 * <p>
 * 参考<href>https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/shou-ba-shou-shua-lian-biao-ti-mu-xun-lian-di-gui-si-wei/pan-duan-hui-wen-lian-biao</href>
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2021-03-27
 * @since 1.0.0
 */
public class Q234Solution {

    public static void main(String[] args) {
//        ListNode node5 = new ListNode(5);
//        ListNode node4 = new ListNode(4, node5);
//        ListNode node3 = new ListNode(3, node4);
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
//        traverse(head);
        System.out.println(isPalindrome2(head));
    }

    static void traverse(ListNode head) {
        if (head == null) {
            return;
        }
        // 先递归
        traverse(head.next);
        // 再用，就是后序遍历
        System.out.print(head.val + "->");

        // 先用
        System.out.print(head.val + "->");

        // 再递归，就是前序遍历
        traverse(head.next);
    }

    /**
     * 判断是否是回文链表
     */
    static boolean isTraverse(ListNode right) {
        // 利用反转链表
        if (right == null) {
            return true;
        }
        // 后序遍历，先递归，再使用，这就是后序遍历，一直递归到末尾节点
        // 类似栈结构，每次出栈一个，就类似右指针左移
        boolean res = isTraverse(right.next);
        // 然后把递归子链表的结果 && val 进行判断
        res = res && (left.val == right.val);
        // 左指针右移，配合出栈（右指针左移）。左右指针同时向中间靠拢
        left = left.next;
        return res;
    }

    /**
     * 左指针
     */
    static ListNode left;

    public static boolean isPalindrome(ListNode head) {
        left = head;
        return isTraverse(head);
    }

    public static boolean isPalindrome2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            // 慢指针，一次走一步
            slow = slow.next;
            // 快指针，一次走两步
            fast = fast.next.next;
        }
        if (fast != null) {
            // 偶数个数链表 1 2 3 4 null
            // 奇数个数链表 1 2 3 4 5
            // 奇数个数时，结束循环时，slow 正好指向正中间3，fast 指向5
            // 偶数个数时，结束循环时，slow 正好指向正中间3，fast 指向null
            // 所以奇数个数时，slow再往前走一步，让4 和 2 去判断
            slow = slow.next;
        }
        ListNode left = head;
        // 这就是末尾节点
        ListNode right = reverse(slow);
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        // 反转链表
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;

            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }


    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListNode {
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

    }

}
