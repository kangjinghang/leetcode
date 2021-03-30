package top.lijngyuan.leetcode.链表.easy.q226_翻转二叉树;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// 输出：
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// 备注:
//这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
// Related Topics 树
// 👍 803 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * q226 solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2021-03-30
 * @since 1.0.0
 */
public class Q226Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node7 = new TreeNode(7, node6, node9);

        TreeNode node4 = new TreeNode(4, node2, node7);

//        invertTree(node4);
        TreeNode root = invertTree1(node4);
    }

    /**
     * 递归，后序遍历，先递归，再用
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newLeft = invertTree(root.right);
        TreeNode newRight = invertTree(root.left);
        root.left = newLeft;
        root.right = newRight;
        return root;
    }

    /**
     * 递归，前序遍历，先用，再递归
     */
    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode p = root.left;
        root.left = root.right;
        root.right = p;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("TreeNode[");
            sb.append("val=").append(val);
            sb.append(", left=").append(left == null ? null : left.val);
            sb.append(", right=").append(right == null ? null : right.val);
            sb.append(']');
            return sb.toString();
        }
    }
}