package top.lijngyuan.leetcode.二叉树.medium.q116_填充每个节点的下一个右侧节点指针;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
// 初始状态下，所有 next 指针都被设置为 NULL。
//
//
//
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
//
//
// 示例：
//
//
//
//
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由
//next 指针连接，'#' 标志着每一层的结束。
//
//
//
//
// 提示：
//
//
// 树中节点的数量少于 4096
// -1000 <= node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 434 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * q116 solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2021-03-30
 * @since 1.0.0
 */
public class Q116Solution {

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node2 = new Node(2, node4, node5);

        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node3 = new Node(3, node6, node7);

        Node node1 = new Node(1, node2, node3);
        Node root = connect(node1);
        System.out.println(root);
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connect(root.left, root.right);
        return root;
    }

    /**
     * 增加函数参数，一个节点做不到，我们就给他安排两个节点，「将每一层二叉树节点连接起来」可以细化成「将每两个相邻节点都连接起来
     */
    public static void connect(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        /**** 前序遍历位置 ****/
        // 将传入的两个节点连接
        left.next = right;

        // 连接相同父节点的两个子节点
        connect(left.left, left.right);
        connect(right.left, right.right);

        // 连接跨越父节点的两个子节点
        connect(left.right, right.left);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int _val) {
            val = _val;
        }

        public Node(int val, Node left, Node right) {
            this(val, left, right, null);
        }

    }

}
