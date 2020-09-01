package top.lijngyuan.leetcode.链表.easy.q21_合并两个有序链表;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
// 👍 1240 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-01
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        // 1->2->4, 1->3->4 ==> 1->1->2->3->4->4
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node14 = new ListNode(4);
        node11.next = node12;
        node12.next = node14;

        ListNode node21 = new ListNode(1);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(4);
        node21.next = node23;
        node23.next = node24;

        ListNode head = mergeTwoLists(node11, node21);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    /**
     * 迭代
     * <p>
     * 首先，我们设定一个哨兵节点 head ，这可以在最后让我们比较容易地返回合并后的链表。
     * 我们维护一个 current 指针，我们需要做的是调整它的 next 指针。
     * 然后，我们重复以下过程，直到 l1 或者 l2 指向了 null ：
     * 如果 l1 当前节点的值小于等于 l2 ，我们就把 l1 当前的节点接在 current 节点的后面同时将 l1 指针往后移一位。
     * 否则，我们对 l2 做同样的操作。不管我们将哪一个元素接在了后面，我们都需要把 current 向后移一位。
     * <p>
     * 在循环终止的时候， l1 和 l2 至多有一个是非空的。由于输入的两个链表都是有序的，
     * 所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。
     * 这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表即可。
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        current.next = l1 == null ? l2 : l1;
        return head.next;
    }

    /**
     * 递归
     * <p>
     * 如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
     * 否则，我们要判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。
     * 如果两个链表有一个为空，递归结束。
     */
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        // 同时也是递归终止条件
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }

        // 判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。如果两个链表有一个为空，递归结束。
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cursor1 = l1, cursor2 = l2, current = head;
        while (cursor1 != null && cursor2 != null) {
            if (cursor1.val <= cursor2.val) {
                current.next = cursor1;
                cursor1 = cursor1.next;
            } else {
                current.next = cursor2;
                cursor2 = cursor2.next;
            }
            current = current.next;
        }
        while (cursor1 != null) {
            current.next = cursor1;
            cursor1 = cursor1.next;
            current = current.next;
        }
        while (cursor2 != null) {
            current.next = cursor2;
            cursor2 = cursor2.next;
            current = current.next;
        }
        return head.next;
    }

}

class ListNode {

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
        return "{" +
                "val=" + val +
                '}';
    }

}