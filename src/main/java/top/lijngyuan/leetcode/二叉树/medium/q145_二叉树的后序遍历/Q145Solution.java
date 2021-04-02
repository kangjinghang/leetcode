package top.lijngyuan.leetcode.二叉树.medium.q145_二叉树的后序遍历;
//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 525 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

import java.util.*;

/**
 * q145 solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2021-02-22
 * @since 1.0.0
 */
public class Q145Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;
        System.out.println(postorderTraversal1(root));
    }

    private static class StackEle {
        TreeNode node;
        boolean visited;

        public StackEle(TreeNode node, boolean visited) {
            this.node = node;
            this.visited = visited;
        }

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<StackEle> stack = new ArrayDeque<>();
        stack.push(new StackEle(root, false));
        while (!stack.isEmpty()) {
            StackEle ele = stack.pop();
            TreeNode cur = ele.node;
            boolean visited = ele.visited;
            if (visited) {
                // 标记左右子节点已经访问过了，可以放心的用父节点了（打印/加到返回list里...这些）。pop出来的就不往回压了
                res.add(cur.val);
            } else {
                // 先把自己压栈，再处理 左右子节点。因为后序是左 右 父，所以压栈顺序反过来
                // pop出来的cur还要再压回去
                stack.push(new StackEle(cur, true));
                // 再压右子节点
                if (cur.right != null) {
                    stack.push(new StackEle(cur.right, false));
                }
                // 再压左子节点
                if (cur.left != null) {
                    stack.push(new StackEle(cur.left, false));
                }
            }
        }
        return res;
    }

    public static List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前序：父 左 右
        // 后序：左 右 父，后序就是把前序反过来 （父、左右） => （左右、父），这里是通过 LinkedList.addFirst() 来实现（双栈）
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.addFirst(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        return res;
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
