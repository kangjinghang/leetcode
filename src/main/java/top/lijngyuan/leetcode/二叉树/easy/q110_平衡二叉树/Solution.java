package top.lijngyuan.leetcode.二叉树.easy.q110_平衡二叉树;
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索
// 👍 510 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-10-29
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
//        TreeNode node9 = new TreeNode(9);
//        TreeNode node20 = new TreeNode(20);
//        root.left = node9;
//        root.right = node20;
//
//        TreeNode node15 = new TreeNode(15);
//        TreeNode node7 = new TreeNode(7);
//        node20.left = node15;
//        node20.right = node7;

        // [1,2,2,3,null,null,3,4,null,null,4]
        root = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        root.left = node21;
        root.right = node22;

        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(3);
        node21.left = node31;
        node22.right = node32;

        TreeNode node41 = new TreeNode(4);
        TreeNode node42 = new TreeNode(4);
        node31.left = node41;
        node32.right = node42;
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced2(TreeNode root) {
        // 自顶向下递归
        if (root == null) {
            return true;
        }
        // 先判断左子节点和右子节点是不是平衡的
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    public static boolean isBalanced(TreeNode root) {
        // 自下向顶递归
        return height(root) >= 0;
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        // 如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 -1
        // 如果存在一棵子树不平衡，则整个二叉树一定不平衡。
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

}

class TreeNode {
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